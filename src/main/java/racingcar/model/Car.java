package racingcar.model;

public class Car {

    private String name;
    private int position;

    private static final int MIN_MOVING_NUM = 4;

    public Car(String name, int startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    public boolean canMoving(int randomValue) {
        if (randomValue >= MIN_MOVING_NUM) {
            return true;
        }
        return false;
    }

    public void move(boolean isMoving) {
        if (isMoving) {
            this.position++;
        }
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
