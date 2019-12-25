package ru.akhitev.rp.fleet.ship.business_logic.vo;

public class ShipVO {
    private final String name;
    private final String className;
    private final Integer speed;
    private final Integer crew;

    public ShipVO(String name, String className, Integer speed, Integer crew) {
        this.name = name;
        this.className = className;
        this.speed = speed;
        this.crew = crew;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getCrew() {
        return crew;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", speed=" + speed +
                ", crew=" + crew +
                '}';
    }
}
