package model;


public class Car {
    private static final int CAR_MOVE_LENGTH = 1;
    private static final int CAR_INITIAL_LENGTH = 0;
    private static final int CAR_MOVE_STANDARD_LENGTH = 4;

    private final Name name;
    private int location;

    public Car(Name name) {
        this.name = name;
        this.location = CAR_INITIAL_LENGTH;
    }

    public void moveByNumber(int moveForNum) {
        if (moveForNum >= CAR_MOVE_STANDARD_LENGTH) {
            this.moveCar();
        }
    }

    private void moveCar() {
        this.location += CAR_MOVE_LENGTH;
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return this.location;
    }

    public boolean checkLocationEqual(Car car) {
        return this.location == car.location;
    }

    public int compareTo(Car car) {
        return this.location - car.location;
    }
}
