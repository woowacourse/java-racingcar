package domain;

import util.Exceptions;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_POWER = 4;

    private final String name;
    private int forward;

    public Car(String name) {
        validate(name);

        this.name = name;
        this.forward = 0;
    }

    private void validate(String name) {
        validateCarNameLength(name);
        validateNameFormat(name);
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Exceptions.MAX_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNameFormat(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(Exceptions.NAME_FORMAT_EXCEPTION.getMessage());
        }
    }

    public void move(int power) {
        if (canMove(power)) {
            forward += 1;
        }
    }

    private boolean canMove(int power) {
        return power >= MIN_POWER;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

}
