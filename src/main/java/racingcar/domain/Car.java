package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final CarName carName;
    private final Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void moveByNumber(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.moveForward();
        }
    }

    public int findBiggerPosition(int winnerPosition) {
        return position.findBiggerPosition(winnerPosition);
    }

    public boolean isSamePosition(int winnerPosition) {
        return position.isSameThan(winnerPosition);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
