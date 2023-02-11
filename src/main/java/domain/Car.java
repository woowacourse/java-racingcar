package domain;

public class Car {

    private final String name;
    private int distance;

    public Car(final String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
