package racingcar.domain;

import racingcar.domain.wrapper.CarName;
import racingcar.domain.wrapper.CarPosition;

import java.util.Objects;

import static racingcar.domain.constant.CarConstant.CAR_FORWARD_NUMBER;

public class Car implements Comparable<Car> {

    private final CarName name;

    private final CarPosition position;

    private Car(final String name) {
        this.name = CarName.create(name);
        this.position = CarPosition.create();
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public void move(final int power) {
        if (power >= CAR_FORWARD_NUMBER.getValue()) {
            position.addPosition();
        }
    }

    public boolean isSamePosition(final Car diffCar) {
        return position.getPosition() == diffCar.position.getPosition();
    }

    @Override
    public boolean equals(Object diffCar) {
        if (this == diffCar) return true;
        if (diffCar == null || getClass() != diffCar.getClass()) return false;
        Car car = (Car) diffCar;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car diffCar) {
        return position.getPosition() - diffCar.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
