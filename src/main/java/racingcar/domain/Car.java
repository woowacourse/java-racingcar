package racingcar.domain;

import racingcar.ui.OutputView;
import racingcar.util.RandomNumber;
import racingcar.util.RandomUtil;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MOVE_BOUNDARY = 4;
    private static final int BOUNDARY_RANDOM_MIN = 0;
    private static final int BOUNDARY_RANDOM_MAX = 9;
    private static final int DEFAULT_FORWARD = 0;
    private static final RandomUtil randomUtil = new RandomNumber();
    private final String name;
    private int forward;


    Car(String name) {
        validate(name);
        this.name = name;
        forward = DEFAULT_FORWARD;
    }

    private static boolean isLongerThanMaxLength(String name) {
        return name.length() > CAR_NAME_MAX_LENGTH;
    }

    private static boolean isBiggerThanBoundary() {
        return randomUtil.generate(BOUNDARY_RANDOM_MIN, BOUNDARY_RANDOM_MAX) >= MOVE_BOUNDARY;
    }

    private void validate(String name) {
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (isBiggerThanBoundary()) {
            forward++;
        }
        printStatus();
    }

    private void printStatus() {
        OutputView.printCarResult(name, forward);
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }
}
