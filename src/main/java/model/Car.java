package model;


public class Car implements Comparable<Car> {
    private static final int CAR_INITIAL_LENGTH = 0;
    private static final int CAR_MOVE_STANDARD_LENGTH = 4;

    private final Name name;
    private final Location location;

    public Car(Name name) {
        this.name = name;
        this.location = new Location(CAR_INITIAL_LENGTH);
    }

    public void moveByNumber(int moveForNum) {
        if (moveForNum >= CAR_MOVE_STANDARD_LENGTH) {
            location.moveCarLocation();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }

    public boolean checkLocationEqual(Car car) {
        return location.checkEqual(car.location);
    }

    @Override
    public int compareTo(Car car) {
        return location.getLocation() - car.getLocation();
    }
}
