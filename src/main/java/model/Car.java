package model;

public class Car implements Comparable<Car> {
    public static final int MOVE_THRESHOLD = 4;

    private final Name name;
    private int distance;

    public Car(Name name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }
}
