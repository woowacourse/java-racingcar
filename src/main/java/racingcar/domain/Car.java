package racingcar.domain;

import racingcar.constant.ErrorLog;
import racingcar.util.Validator;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int LEFT_BOUND_INCLUSIVE = 0;
    private static final int RIGHT_BOUND_INCLUSIVE = 9;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        Validator.validateNotEmptyInput(name);
        validateNameLength(name);
    }

    private static void validateNameLength(String str) {
        if (str.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorLog.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position++;
        }
    }

    public boolean isMovable(int value) {
        if (value < LEFT_BOUND_INCLUSIVE || value > RIGHT_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorLog.INVALID_VALUE.getMessage());
        }
        return value >= THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
