package ru.akhitev.rp.fleet.ship.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "speed")
@SequenceGenerator(name = "seq", initialValue = 20)
public class Defence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "defence")
    private Ship ship;

    @Column(name = "shield")
    private Double shield;

    @Column(name = "hull_dr")
    private Double hullDr;

    @Column(name = "hull_hr")
    private Double hullHr;

    @Column(name = "damage_threshold")
    private Double damageThreshold;

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

    public Double getShield() {
        return shield;
    }

    public void setShield(Double shield) {
        this.shield = shield;
    }

    public Double getHullDr() {
        return hullDr;
    }

    public void setHullDr(Double hullDr) {
        this.hullDr = hullDr;
    }

    public Double getHullHr() {
        return hullHr;
    }

    public void setHullHr(Double hullHr) {
        this.hullHr = hullHr;
    }

    public Double getDamageThreshold() {
        return damageThreshold;
    }

    public void setDamageThreshold(Double damageThreshold) {
        this.damageThreshold = damageThreshold;
    }
}
