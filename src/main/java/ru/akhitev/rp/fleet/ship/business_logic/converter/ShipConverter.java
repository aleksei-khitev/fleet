package ru.akhitev.rp.fleet.ship.business_logic.converter;

import org.springframework.core.convert.converter.Converter;
import ru.akhitev.rp.fleet.ship.business_logic.vo.ShipVO;
import ru.akhitev.rp.fleet.ship.db.entity.Ship;

public class ShipConverter implements Converter<Ship, ShipVO> {

    @Override
    public ShipVO convert(Ship ship) {
        return new ShipVO(ship.getName(), ship.getClassName(), ship.getSpeed(), ship.getCrew());
    }
}
