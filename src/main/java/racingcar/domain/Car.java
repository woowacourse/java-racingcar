package racingcar.domain;

import racingcar.domain.dto.CarRaceDto;
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

    public CarRaceDto getCarRaceResult() {
        return CarRaceDto.of(name.getName(), position.getPosition());
    }

    public void move(final int power) {
        if (power >= CAR_FORWARD_NUMBER.getValue()) {
            position.addPosition();
        }
    }

    public boolean isSamePosition(final int position) {
        return this.position.getPosition() == position;
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

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
