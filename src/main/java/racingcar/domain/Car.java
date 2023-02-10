package racingcar.domain;

import java.util.Objects;
import java.util.Random;

import static racingcar.exception.ErrorMessages.CAR_NAME_BLANK_EXCEPTION;
import static racingcar.exception.ErrorMessages.CAR_NAME_LENGTH_EXCEPTION;

public class Car {
    private final String name;
    private int position;
    private CarMovement carMovement;

    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    public Car(String name, NumberGenerator numberGenerator) {
        validateNameNullOrBlank(name);
        validateNameLength(name);
        this.name = name;
        position = 0;
        carMovement = new CarMovement(numberGenerator);
    }

    public void move() {
        if (carMovement.isCarMoveForward()) {
            position++;
        }
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
