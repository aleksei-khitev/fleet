package ru.akhitev.rp.fleet.ship.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "crew")
@SequenceGenerator(name = "seq", initialValue = 20)
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "crew")
    private Ship ship;

    @Column(name = "normal_crew")
    private Integer normalCrew;

    @Column(name = "minimum_crew")
    private Integer minimumCrew;

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

    public Integer getNormalCrew() {
        return normalCrew;
    }

    public void setNormalCrew(Integer normalCrew) {
        this.normalCrew = normalCrew;
    }

    public Integer getMinimumCrew() {
        return minimumCrew;
    }

    public void setMinimumCrew(Integer minimumCrew) {
        this.minimumCrew = minimumCrew;
    }
}
