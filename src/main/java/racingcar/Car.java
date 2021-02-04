package racingcar;

import racingcar.exception.InvalidCarNameLengthException;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidCarNameLengthException();
        }

        this.name = name;
    }

    public void goForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
