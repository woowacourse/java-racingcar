package model;


public class Car {
    private static final int CAR_MOVE_LENGTH = 1;
    private static final int CAR_INITIAL_LENGTH = 0;

    private Name name;
    private int location;

    public Car(Name name) {
        this.name = name;
        this.location = CAR_INITIAL_LENGTH;
    }

    private void moveCar() {
        this.location += CAR_MOVE_LENGTH;
    }

    public void moveByRandom(boolean move) {
        if (move) {
            this.moveCar();
        }
    }

    public Name getCarName() {
        return this.name;
    }

    public int getCarLocation() {
        return this.location;
    }

    public boolean checkLocationEqual(int maxLocation) {
        return this.location == maxLocation;
    }
}
