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
        if (this.position > compareCar.getPosition()) {
            return this;
        }
        return compareCar;
    }

    public Car getSamePositionCar(Car maxPositionCar) {
        if (this.position == maxPositionCar.getPosition()) {
            return this;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
