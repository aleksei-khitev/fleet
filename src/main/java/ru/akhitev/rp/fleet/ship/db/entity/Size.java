package ru.akhitev.rp.fleet.ship.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "size")
@SequenceGenerator(name = "seq", initialValue = 20)
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "size")
    private Ship ship;

    @Column(name = "length")
    private Double length;

    @Column(name = "height")
    private Double height;

    @Column(name = "width")
    private Double width;

    public Size() {
    }

    public Size(int id, Ship ship, Double length, Double height, Double width) {
        this.id = id;
        this.ship = ship;
        this.length = length;
        this.height = height;
        this.width = width;
    }

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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
