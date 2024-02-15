package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.util.RandomUtil;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MOVE_BOUNDARY = 4;
    private final String name;
    private int forward;
    private static final RandomUtil randomUtil = new RandomNumber();

    Car(String name) {
        validate(name);
        this.name = name;
        forward = 0;
    }

    private void validate(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    String getName() {
        return name;
    }

    int getForward() {
        return forward;
    }

    public void move() {
        if (randomUtil.generate(0, 9) >= MOVE_BOUNDARY) {
            forward++;
        }
    }
}
