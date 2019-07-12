package ru.akhitev.rp.fleet.ship.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
@SequenceGenerator(name = "seq", initialValue = 20)
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "sensor")
    private Ship ship;

    @Column(name = "passive_mode")
    private Double passiveMode;

    @Column(name = "scanning")
    private Double scanning;

    @Column(name = "searching")
    private Double searching;

    @Column(name = "focus")
    private Double focus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Double getPassiveMode() {
        return passiveMode;
    }

    public void setPassiveMode(Double passiveMode) {
        this.passiveMode = passiveMode;
    }

    public Double getScanning() {
        return scanning;
    }

    public void setScanning(Double scanning) {
        this.scanning = scanning;
    }

    public Double getSearching() {
        return searching;
    }

    public void setSearching(Double searching) {
        this.searching = searching;
    }

    public Double getFocus() {
        return focus;
    }

    public void setFocus(Double focus) {
        this.focus = focus;
    }
}
