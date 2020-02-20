package racingcar.domian.car;

import java.util.Objects;

public class Car {
    private static final int INIT_POSITION = 0;
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int LIMIT_FOR_MOVE = 4;

    private Position position;
    private String name;

    public Car(String name) {
        this(new Position(INIT_POSITION), name);
    }

    public Car(Position position, String name) {
        this.position = position;
        this.name = validateName(name);
    }

    public int getDistance() {
        return this.position.getDistance();
    }

    public String getName() {
        return name;
    }

    public void isMovable(int number) {
        if (number >= LIMIT_FOR_MOVE) {
            position.move();
        }
    }

    private static String validateName(String name) {
        validateNullOrEmpty(name);
        validateNameLength(name);
        return name.trim();
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값 혹은 Null 입력입니다!");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름 길이 5자 초과입니다!");
        }
    }

    public int getBiggerPosition(int maxPosition) {
        if (isBiggerThanMaxPosition(maxPosition)) {
            return position.getDistance();
        }
        return maxPosition;
    }

    private boolean isBiggerThanMaxPosition(int maxPosition) {
        return position.getDistance() > maxPosition;
    }

    public boolean isWinner(int maxPosition) {
        return position.getDistance() == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
