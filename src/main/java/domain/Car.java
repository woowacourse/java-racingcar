package domain;

public class Car implements Comparable<Car> {

    private Distance distance; //TODO: final
    private String name;

    public Car(String name, Distance distance) {
        validate(name);
        this.name = name;
        this.distance = distance;
    }

    private void validate(String name) {
        if (!isValidSize(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidSize(String name) {
        return name.length() >= 1 && name.length() <= 5;
    }


    public static Car fromName(String name) {
        return new Car(name, Distance.init());
    }

    public static Car fromEmpty() {
        return new Car("", Distance.init());
    }


    public void move() {
        distance.increase();
    }

    public Distance getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public boolean isSameDistance(Car maxDistance) {
        return distance.isSameDistance(maxDistance.distance);
    }
    @Override
    public int compareTo(Car other) {
        return this.distance.compareTo(other.distance);
    }
}
