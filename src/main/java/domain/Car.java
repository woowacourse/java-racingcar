package domain;

public class Car {

    private int distance;
    private String name;

    public Car(String name) {
        validate(name);
        this.name = name;
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
        return new Car(name);
    }

    public static Car fromEmpty() {
        return new Car("");
    }


    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public boolean isSameDistance(int maxDistance) {
        return distance == maxDistance;
    }
}
