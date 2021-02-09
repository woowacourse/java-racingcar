package racingcar.domain.car;

import racingcar.domain.car.util.MovingStrategy;

import java.util.Objects;

public class Car {

    private final CarName name;
    private final CarPosition carPosition;

    public Car(String name) {
        this(new CarName(name), new CarPosition());
    }

    public Car(CarName name, CarPosition carPosition) {
        this.name = name;
        this.carPosition = carPosition;
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            return new Car(name, carPosition.move());
        }

        return this;
    }

    public boolean equalToPosition(int maxPosition) {
        return carPosition.equalToPosition(maxPosition);
    }

    public String getName() {
        return name.toStringName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(carPosition, car.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carPosition);
    }
}