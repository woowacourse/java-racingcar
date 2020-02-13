package domain;

import java.util.Objects;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_MOVABLE_NUM = 4;
    private static final String WRONG_NAME_LENGTH_MESSAGE = "이름 길이는 1~5 이여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name.trim();
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(WRONG_NAME_LENGTH_MESSAGE);
        }
    }

    public boolean move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_NUM) {
            position++;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
