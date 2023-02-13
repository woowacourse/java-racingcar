package domain;

public class Car {

    private static final int DEFAULT_DISTANCE_VALUE = 0;

    private Name name;
    private int distance;

    public Car(final Name name) {
        this.name = name;
        this.distance = DEFAULT_DISTANCE_VALUE;
    }

    public void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name.getName();
    }
}
