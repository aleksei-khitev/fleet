package ru.akhitev.rp.fleet.ship.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship")
@SequenceGenerator(name = "seq", initialValue = 20)
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "localized_name")
    private String localizedName;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "autonomy")
    private Long autonomy; // in days

    @Column(name = "cargo_capacity")
    private Double cargoCapacity;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Size size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew_id", referencedColumnName = "id")
    private Crew crew;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speed_id", referencedColumnName = "id")
    private Speed speed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "defence_id", referencedColumnName = "id")
    private Defence defence;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getAutonomy() {
        return autonomy;
    }

    public void setAutonomy(Long autonomy) {
        this.autonomy = autonomy;
    }

    public Double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Defence getDefence() {
        return defence;
    }

    public void setDefence(Defence defence) {
        this.defence = defence;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
