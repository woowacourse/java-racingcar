package domain;

public class Car {
    private static final int CAR_LOCATION_INITIALIZATION = 0;
    private static final int CAR_MOVE_FORWARD = 1;
    private static final int MIN_NUMBER_FOR_CAR_MOVE = 4;

    private final Name name;
    private int location;

    public Car(Name name) {
        this.name = name;
        this.location = CAR_LOCATION_INITIALIZATION;
    }

    public void moveByNumber(int number) {
        if (number >= MIN_NUMBER_FOR_CAR_MOVE) {
            this.moveCar();
        }
    }

    private void moveCar() {
        this.location += CAR_MOVE_FORWARD;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getLocation() {
        return this.location;
    }

    public boolean isLocationEqual(int maxLocation) {
        return this.location == maxLocation;
    }
}
