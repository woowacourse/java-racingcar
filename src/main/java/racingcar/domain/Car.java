package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int CONDITION = 4;

    private final CarName carName;

    private Position position;

    public Car(String carNameValue) {
        this(carNameValue, 0);
    }

    public Car(String carNameValue, int position) {
        this.carName = new CarName(carNameValue);
        this.position = new Position(position);

    }

    public void move(int randomNumber) {
        if (randomNumber >= CONDITION) {
            this.position = position.move();
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return position.isMaxPosition(maxDistance);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
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
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return this.carName.getCarName() + " : " + position;
    }

}
