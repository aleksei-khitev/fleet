package ru.akhitev.rp.fleet.ship.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.akhitev.rp.fleet.ship.db.entity.*;
import ru.akhitev.rp.fleet.ship.db.repo.*;

import java.util.Optional;
import java.util.Scanner;

@Controller
@RequestMapping("/ship")
public class ShipController {
    private ShipRepository shipRepository;
    private SizeRepository sizeRepository;
    private CrewRepository crewRepository;
    private SpeedRepository speedRepository;
    private DefenceRepository defenceRepository;
    private SensorRepository sensorRepository;

    public ShipController(ShipRepository shipRepository, SizeRepository sizeRepository, CrewRepository crewRepository, SpeedRepository speedRepository, DefenceRepository defenceRepository, SensorRepository sensorRepository) {
        this.shipRepository = shipRepository;
        this.sizeRepository = sizeRepository;
        this.crewRepository = crewRepository;
        this.speedRepository = speedRepository;
        this.defenceRepository = defenceRepository;
        this.sensorRepository = sensorRepository;
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("ships", shipRepository.findAll());
        return "ship/list";
    }

    @RequestMapping(value = "/add/main")
    public String add(Model model) {
        return "ship/add/main";
    }

    @RequestMapping(value = "/save/main", method = RequestMethod.POST)
    public String saveMain(@RequestParam("name") String name,
                       @RequestParam("localized_name") String localizedName,
                       @RequestParam("manufacturer") String manufacturer,
                       @RequestParam("autonomy") String autonomy,
                       @RequestParam("cargo_capacity") String cargoCapacity,
                       @RequestParam("description") String description,
                       @RequestParam("link") String link,
                       @RequestParam("cost") Double cost,
                       Model model) {
        Ship ship = new Ship();
        ship.setName(name);
        ship.setLocalizedName(localizedName);
        ship.setManufacturer(manufacturer);
        if (autonomy != null) ship.setAutonomy(Long.valueOf(autonomy));
        if (cargoCapacity != null) ship.setCargoCapacity(Double.valueOf(cargoCapacity));
        if (description != null) ship.setDescription(description);
        if (link != null) ship.setLink(link);
        if (cost != null) ship.setCost(cost);
        Integer shipId = shipRepository.save(ship).getId();
        model.addAttribute("shipId", shipId);
        return "ship/add/size";
    }

    @RequestMapping(value = "/save/size", method = RequestMethod.POST)
    public String saveSize(@RequestParam("length") Double length,
                       @RequestParam("height") Double height,
                       @RequestParam("width") Double width,
                       @RequestParam("ship_id") Integer shipId,
                       Model model) {
        Size size = new Size();
        size.setLength(length);
        if (height != null) size.setHeight(height);
        if (width != null) size.setWidth(width);
        Ship ship = shipRepository.getOne(shipId);
        size.setShip(ship);
        ship.setSize(sizeRepository.saveAndFlush(size));
        shipRepository.saveAndFlush(ship);
        model.addAttribute("shipId", shipId);
        return "ship/add/crew";
    }

    @RequestMapping(value = "/save/crew", method = RequestMethod.POST)
    public String saveCrew(@RequestParam("normal_crew") Integer normalCrew,
                            @RequestParam("minimum_crew") Integer minimumCrew,
                            @RequestParam("ship_id") Integer shipId,
                            Model model) {
        Crew crew = new Crew();
        if (normalCrew != null) crew.setNormalCrew(normalCrew);
        if (minimumCrew != null) crew.setMinimumCrew(minimumCrew);
        Ship ship = shipRepository.getOne(shipId);
        crew.setShip(ship);
        ship.setCrew(crewRepository.saveAndFlush(crew));
        shipRepository.saveAndFlush(ship);
        model.addAttribute("shipId", shipId);
        return "ship/add/speed";
    }

    @RequestMapping(value = "/save/speed", method = RequestMethod.POST)
    public String saveSpeed(@RequestParam("cruising_speed") Double cruisingSpeed,
                           @RequestParam("maximum_speed") Double maximumSpeed,
                           @RequestParam("hyper_drive") String hyperDrive,
                           @RequestParam("hyper_drive_backup") String hyperDriveBackUp,
                           @RequestParam("ship_id") Integer shipId,
                           Model model) {
        Speed speed = new Speed();
        if (cruisingSpeed != null) speed.setCruisingSpeed(cruisingSpeed);
        if (maximumSpeed != null) speed.setMaximumSpeed(maximumSpeed);
        if (hyperDrive != null) speed.setHyperDrive(hyperDrive);
        if (hyperDriveBackUp != null) speed.setHyperDriveBackUp(hyperDriveBackUp);
        Ship ship = shipRepository.getOne(shipId);
        speed.setShip(ship);
        ship.setSpeed(speedRepository.saveAndFlush(speed));
        shipRepository.saveAndFlush(ship);
        model.addAttribute("shipId", shipId);
        return "ship/add/defence";
    }

    @RequestMapping(value = "/save/defence", method = RequestMethod.POST)
    public String saveDefence(@RequestParam("shield") Double shield,
                            @RequestParam("hull_dr") Double hullDr,
                            @RequestParam("hull_hr") Double hullHr,
                            @RequestParam("damage_threshold") Double damageThreshold,
                            @RequestParam("ship_id") Integer shipId,
                           Model model) {
        Defence defence = new Defence();
        if (shield != null) defence.setShield(shield);
        if (hullDr != null) defence.setHullDr(hullDr);
        if (hullHr != null) defence.setHullHr(hullHr);
        if (damageThreshold != null) defence.setDamageThreshold(damageThreshold);
        Ship ship = shipRepository.getOne(shipId);
        defence.setShip(ship);
        ship.setDefence(defenceRepository.saveAndFlush(defence));
        shipRepository.saveAndFlush(ship);
        model.addAttribute("shipId", shipId);
        return "ship/add/sensor";
    }

    @RequestMapping(value = "/save/sensor", method = RequestMethod.POST)
    public String saveSensor(@RequestParam("passive_mode") Double passiveMode,
                              @RequestParam("scanning") Double scanning,
                              @RequestParam("searching") Double searching,
                              @RequestParam("focus") Double focus,
                              @RequestParam("ship_id") Integer shipId,
                              Model model) {
        Sensor sensor = new Sensor();
        if (passiveMode != null) sensor.setPassiveMode(passiveMode);
        if (scanning != null) sensor.setScanning(scanning);
        if (searching != null) sensor.setSearching(searching);
        if (focus != null) sensor.setFocus(focus);
        Ship ship = shipRepository.getOne(shipId);
        sensor.setShip(ship);
        ship.setSensor(sensorRepository.saveAndFlush(sensor));
        shipRepository.saveAndFlush(ship);
        model.addAttribute("shipId", shipId);
        return view(shipId, model);
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id, Model model) {
        Optional<Ship> ship = shipRepository.findById(id);
        model.addAttribute("ship", ship.get());
        return "ship/view";
    }
}
