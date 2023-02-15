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
        return randomValue >= MIN_MOVING_NUM;
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

    public boolean isSamePositionCar(Car maxPositionCar) {
        return this.position == maxPositionCar.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
