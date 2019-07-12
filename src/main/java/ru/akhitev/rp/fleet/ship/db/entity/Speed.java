package ru.akhitev.rp.fleet.ship.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "speed")
@SequenceGenerator(name = "seq", initialValue = 20)
public class Speed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "speed")
    private Ship ship;

    @Column(name = "cruising_speed")
    private Double cruisingSpeed;

    @Column(name = "maximum_speed")
    private Double maximumSpeed;

    @Column(name = "hyper_drive")
    private String hyperDrive;

    @Column(name = "hyper_drive_backup")
    private String hyperDriveBackUp;

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

    public Double getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(Double cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public Double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public String getHyperDrive() {
        return hyperDrive;
    }

    public void setHyperDrive(String hyperDrive) {
        this.hyperDrive = hyperDrive;
    }

    public String getHyperDriveBackUp() {
        return hyperDriveBackUp;
    }

    public void setHyperDriveBackUp(String hyperDriveBackUp) {
        this.hyperDriveBackUp = hyperDriveBackUp;
    }
}
