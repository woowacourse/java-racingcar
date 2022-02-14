package racingcar;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 5글자를 초과할 수 없습니다.";
    private static final String EMPTY_NAME_ERROR = "[ERROR] 이름은 공백일 수 없습니다.";
    private static final String TO_STRING_CONJUNCTION = " : ";
    private static final String POSITION_CHARACTOR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        validateEmptyName(name);
        validateName(name);
        this.name = name;
        position = 0;
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }

    public void move(boolean canCarMove) {
        if (canCarMove) {
            position++;
        }
    }

    private String buildStringPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_CHARACTOR);
        }
        return stringBuilder.toString();
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

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + TO_STRING_CONJUNCTION + buildStringPosition();
    }
}
