package racingcar.domain;

import racingcar.domain.vo.CarStatus;

import java.util.Objects;

import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class Car {

    public static final int START_POSITION = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private int position;

    private Car(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name.trim();
        this.position = START_POSITION;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move(final boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public CarStatus getCarStatus() {
        return CarStatus.of(name, position);
    }

    public String getName() {
        return getCarStatus().getName();
    }

    public int getPosition() {
        return getCarStatus().getPosition();
    }

    private void validateNameLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
