package model;

import static util.ErrorMessage.*;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_MIN_NUMBER = 4;
    private static final String NAME_DELIMITER = " : ";
    private static final String TRACE = "-";

    private int position;
    private String name;

    public Car(String name) {
        validate(name);
        this.position = INITIAL_POSITION;
        this.name = name;
    }

    private void validate(String name) {
        checkBlankOrNull(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalStateException(ERROR_NAME_LENGTH.getMessage());
        }
    }

    private void checkBlankOrNull(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException(ERROR_IS_BLANK_OR_NULL.getMessage());
        }
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= FORWARD_MIN_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder();
        trace.append(name).append(NAME_DELIMITER);
        for (int i = 0; i < position; i++) {
            trace.append(TRACE);
        }
        return trace.toString();
    }
}