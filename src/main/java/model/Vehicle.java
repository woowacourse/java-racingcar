package model;

public class Vehicle implements MovableStrategy {
    private final String name;
    private int distance;

    public Vehicle(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void updateDistance() {
        distance++;
    }

    @Override
    public boolean isMove() {
        return false;
    }
}
