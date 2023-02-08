package domain;

public class Car {

    private String name;

    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
