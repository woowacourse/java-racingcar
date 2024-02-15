package model;

public class Car implements Comparable<Car> {
    private final Name name;
    private int distance;

    public Car(Name name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        distance++;
    }

    public String showDistance() {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < this.distance; i++) {
            distance.append("-");
        }

        return distance.toString();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }
}
