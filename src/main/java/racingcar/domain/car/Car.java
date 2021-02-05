package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private static final String ERROR_NAME_NOT_PERMIT_NULL_MESSAGE = "[ERROR] 자동차 이름은 null을 허용하지 않습니다.";
    private static final String ERROR_NAME_HAS_NOT_SPECIAL_CHARACTER_MESSAGE = "[ERROR] 자동차 이름에 특수문자를 사용할 수 없습니다.";
    private static final String ERROR_NAME_NOT_PERMIT_EMPTY_MESSAGE = "[ERROR] 자동차 이름은 공백을 허용하지 않습니다.";
    private static final String ERROR_NAME_NOT_LONGER_THAN_NAME_LIMIT_MESSAGE = "[ERROR] 자동차 이름의 길이는 최대 5글자 입니다.";
    private static final int NAME_LENGTH_MAX_LIMIT = 5;
    private static final int FORWARD_MOVEMENT_BOUNDARY_VALUE = 4;
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        validateNull(name);
        validateEmpty(name);
        validateLength(name);
        validateSpecialCharacters(name);
    }

    private void validateSpecialCharacters(String name) {
        for (char partOfName : name.toCharArray()) {
            validateSpecialCharacter(partOfName);
        }
    }

    private void validateSpecialCharacter(char partOfName) {
        if (Character.isLetterOrDigit(partOfName)) {
            return;
        }

        throw new IllegalArgumentException(ERROR_NAME_HAS_NOT_SPECIAL_CHARACTER_MESSAGE);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ERROR_NAME_NOT_PERMIT_NULL_MESSAGE);
        }
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NAME_NOT_PERMIT_EMPTY_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() > NAME_LENGTH_MAX_LIMIT) {
            throw new IllegalArgumentException(ERROR_NAME_NOT_LONGER_THAN_NAME_LIMIT_MESSAGE);
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_MOVEMENT_BOUNDARY_VALUE) {
            position++;
        }
    }

    public boolean equalToPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
