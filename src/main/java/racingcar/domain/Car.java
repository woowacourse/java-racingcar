package racingcar.domain;

import racingcar.constant.Digit;
import racingcar.constant.Message;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if ((name.length() < Digit.MINIMUM_CAR_NAME_LENGTH.getDigit())
                || (name.length() > Digit.MAXIMUM_CAR_NAME_LENGTH.getDigit())) {
            throw new IllegalArgumentException(Message.CAR_NAME_LENGTH_ERROR.toString());
        }
    }

    public void move() {
        position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
