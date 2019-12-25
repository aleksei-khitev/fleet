package ru.akhitev.rp.fleet.ship.business_logic;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.akhitev.rp.fleet.ship.business_logic.vo.ShipVO;
import ru.akhitev.rp.fleet.ship.db.entity.Ship;
import ru.akhitev.rp.fleet.ship.db.repo.ShipRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShipService {
    private ShipRepository repository;
    private ConversionService conversionService;

    public ShipService(ShipRepository repository, ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public Set<ShipVO> allShips() {
        Set<ShipVO> ships = new HashSet<>();
        for (Ship ship : repository.findAll()) {
            ships.add(conversionService.convert(ship, ShipVO.class));
        }
        return ships;
    }

    public ShipVO byName(String name) {
        return conversionService.convert(repository.findByName(name), ShipVO.class);
    }
}
