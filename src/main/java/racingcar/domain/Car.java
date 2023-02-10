package racingcar.domain;

import java.util.Objects;

import static racingcar.exception.ErrorMessages.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.exception.ErrorMessages.CAR_NAME_LENGTH_EXCEPTION;

public class Car {
    final String name;
    int position;

    public Car(String name) {
        validateNameNullOrBlank(name);
        validateNameLength(name);
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameNullOrBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    private void validateNameLength(String name) {
        int nameLength = name.length();
        if (nameLength > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    public void move() {
        CarMovement carMovement = new CarMovement(new RandomNumberGenerator());
        if (carMovement.isCarMoveForward()) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;

        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
