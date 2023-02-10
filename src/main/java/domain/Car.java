package domain;

import vo.Name;
import vo.Position;

public class Car {
    public static final int MIN_REQUIRED_POWER = 3;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String INVALID_NAME_LENGTH_EXCEPTION_MESSAGE = "5글자 까지만 가능합니다.";

    private final Name name;
    private Position position;

    public Car(Name name) {
        validateName(name);
        this.name = name;
        this.position = Position.of(0L);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(int power) {
        if (power > MIN_REQUIRED_POWER) {
            position = position.plus();
        }
    }

    private void validateName(Name name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public boolean hasPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
