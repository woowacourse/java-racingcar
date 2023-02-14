package domain;

import java.util.Objects;

public class Car {

    private final static int MIN_MOVE_NUMBER = 4;

    private final CarName carName;
    private int moveCount;

    public Car(String name) {
        this.carName = new CarName(name);
        this.moveCount = 0;
    }

    public void move() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean canMove(int number) {
        return number >= MIN_MOVE_NUMBER;
    }

    public boolean isWinner(int maxMoveCount) {
        return moveCount == maxMoveCount;
    }

    public String getCarName() {
        return carName.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getCarName(), car.getCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName());
    }
}
