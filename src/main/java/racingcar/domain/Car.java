package racingcar.domain;

import java.util.Objects;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
    private static final String EMPTY_NAME_ERROR = "[ERROR] 이름은 공백일 수 없습니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateEmptyName(name);
        validateName(name);
        this.name = name;
    }

    private void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
