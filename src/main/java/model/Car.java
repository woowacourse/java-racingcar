package model;

import java.util.Objects;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 1~5 글자여야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    Position position = new Position();

    public Car(String name) {
        validateName(name);
        this.name = name;
    }


    static void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void moveOrNot(int number) {
        this.position.move(number);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position.getPosition();
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

