package racingcar.domain;

import racingcar.validator.CarValidator;

import java.util.Objects;

public class Car {
    private static final int MIN_VALUE_TO_MOVE = 4;

    private final String name;
    private int position;

    private Car(String name) {
        this(name, 0);
    }

    private Car(String name, int position) {
        this.name = name.trim();
        this.position = position;
    }

    public static Car of(String name) {
        return Car.of(name, 0);
    }

    public static Car of(String name, int position) {
        CarValidator.validateCarNameIsNullOrEmpty(name);
        String trimmedName = name.trim();
        CarValidator.validateCarNameLength(trimmedName);
        return new Car(trimmedName, position);
    }

    public static Car getInstance(Car car) {
        return new Car(car.getName(), car.getPosition());
    }

    public void tryToMove(int number) {
        if (number >= MIN_VALUE_TO_MOVE) {
            this.position++;
        }
    }

    public boolean isSamePosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getMaxPosition(int position) {
        return Math.max(this.position, position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
