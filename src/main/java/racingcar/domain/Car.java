package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.util.Validator;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int LEFT_BOUND_INCLUSIVE = 0;
    private static final int RIGHT_BOUND_INCLUSIVE = 9;
    private static final int EACH_STEP = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = 0;
    }

    private static void validateNameLength(String str) {
        if (str.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private void validateName(String name) {
        Validator.validateNotEmptyInput(name);
        validateNameLength(name);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position += EACH_STEP;
        }
    }

    public boolean isMovable(int value) {
        if (value < LEFT_BOUND_INCLUSIVE || value > RIGHT_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getMessage());
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
