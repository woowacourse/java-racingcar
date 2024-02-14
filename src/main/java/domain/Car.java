package domain;

public class Car {
    private final String name;
    private int distance = 0;

    Car(final String name) {
        this.name = name;
    }

    public void moveForward() {
        distance++;
    }

    public String getCarName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }
}
