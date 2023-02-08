package model;

public class Car {

    private String name;
    private int position;

    public Car(String name, int startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    public boolean canMoving(int randomValue) {
        return true;
    }

    public void move(boolean isMoving) {

    }

    public Car getLargerCar(Car compareCar) {
        return this;
    }

    public Car getSamePositionCar(Car maxPositionCar) {
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
