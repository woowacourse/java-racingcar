package racingcar.domain;

import racingcar.constant.ErrorLog;
import racingcar.util.Validator;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int LEFT_BOUND = 0;
    private static final int RIGHT_BOUND = 9;
    private final String name;
    private int position;
    private int turnCount;

    public Car(String name) {
        Validator.validateNameLength(name);
        Validator.validateNotEmptyInput(name);

        this.name = name;
        this.position = 0;
        this.turnCount = 0;
    }

    public void move(int value) {
        if (value < LEFT_BOUND || value > RIGHT_BOUND) {
            throw new IllegalArgumentException(ErrorLog.INVALID_VALUE.getMessage());
        }
        if (value >= THRESHOLD) {
            position++;
        }
        turnCount++;
    }

    public int getPosition() {
        return position;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public String getName() {
        return name;
    }
}
