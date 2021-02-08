package racingcar.domain;

import racingcar.constant.Digit;
import racingcar.constant.Message;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, Digit.START_POSITION.getDigit());
    }

    public Car(String name, int position) {
        validateLength(name);
        this.name = name;
        this.position = position;
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

    @Override
    public String toString() {
        StringBuilder hyphens = new StringBuilder();

        for (int i = 0; i < position; i++) {
            hyphens.append(Message.HYPHEN);
        }

        return name + Message.COLON_WITH_BLANK + hyphens.toString();
    }
}
