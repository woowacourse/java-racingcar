package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVE_FORWARD = 4;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final Name name;
    private int position;

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
        validateCarNameLength(name);
    }

    public Car(Name name) {
        this(name, MINIMUM_POSITION);
    }

    public void move(int number) {
        if (canMove(number)) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    private void validateCarNameLength(Name carName) {
        boolean isValidLength = carName.getName().length() <= MAXIMUM_CAR_NAME_LENGTH;
        if (!isValidLength) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_FORWARD;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
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
