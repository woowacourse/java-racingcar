package racingcar.model.car;

import racingcar.model.car.strategy.MovingStrategy;

public class Car {
    private static final int DEFAULT_POSITION = 1;

    private final CarName carName;
    private int position = DEFAULT_POSITION;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = new CarName(carName);
        this.movingStrategy = movingStrategy;
    }

    public void moveForward() {
        position += 1;
    }

    public boolean matchPosition(int otherPosition) {
        return position == otherPosition;
    }

    public boolean movable() {
        return movingStrategy.movable();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position;
    }
}
