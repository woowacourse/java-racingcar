package racingcar.domain;

import racingcar.domain.wrapper.CarName;
import racingcar.domain.wrapper.CarPosition;

import java.util.Objects;

import static racingcar.domain.constant.CarConstant.CAR_FORWARD_NUMBER;

public class Car {

    private final CarName name;

    private final CarPosition position;

    private Car(final String name) {
        this.name = CarName.of(name);
        this.position = CarPosition.of();
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move(int power) {
        if (power >= CAR_FORWARD_NUMBER.getValue()) {
            position.addPosition();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
