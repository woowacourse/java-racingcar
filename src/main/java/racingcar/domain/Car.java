package racingcar.domain;

import racingcar.util.Validation;

public class Car {
    private static final int GO_FORWARD_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        Validation.carNameValidation(name);
        this.name = name;
    }

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward(final int num) {
        if (num >= GO_FORWARD_CONDITION) {
            position += 1;
        }
    }

    public boolean checkIfPositionSame(final int position) {
        return this.position == position;
    }
}
