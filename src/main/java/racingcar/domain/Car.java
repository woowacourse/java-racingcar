package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final String BLANK = " ";
    public static final String BLANK_ERROR_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final Position INIT_POSITION = new Position(0);
    private static final int MOVABLE_VALUE = 4;

    //TODO
    // 원시타입을 포장해보자
    // Position
    // Name
    private Position position;
    private final String name;

    public Car(String name) {
        this(name, INIT_POSITION);
    }

    public Car(String name, Position position) {
        validateBlankInName(name);
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public static void validateBlankInName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void move(int number) {
        if (isMovable(number)) {
            this.position = position.getPositionAfterMove();
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_VALUE;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Position getPosition() {
        return new Position(position.getPosition());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position.equals(car.position) && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}