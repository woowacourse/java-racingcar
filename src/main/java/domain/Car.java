package domain;

public class Car {

    private static final int DEFAULT_DISTANCE_VALUE = 0;

    private final String name;

    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = DEFAULT_DISTANCE_VALUE;
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
