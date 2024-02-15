package racingcar.domain;

import racingcar.ui.OutputView;
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
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLongerThanMaxLength(String name) {
        return name.length() > CAR_NAME_MAX_LENGTH;
    }

    public void move() {
        if (isBiggerThanBoundary()) {
            forward++;
        }
        printStatus();
    }

    private static boolean isBiggerThanBoundary() {
        return randomUtil.generate(0, 9) >= MOVE_BOUNDARY;
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
