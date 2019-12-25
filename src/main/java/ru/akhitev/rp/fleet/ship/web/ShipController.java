package ru.akhitev.rp.fleet.ship.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.akhitev.rp.fleet.ship.business_logic.ShipService;
import ru.akhitev.rp.fleet.ship.business_logic.vo.ShipVO;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/rest/ship")
public class ShipController {
    private ShipService service;

    public ShipController(ShipService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public Set<ShipVO> list(Model model) {
        return service.allShips();
    }
}
