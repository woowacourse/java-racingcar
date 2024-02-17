package racingcar.model;

import racingcar.constants.Constants;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        checkIfNameUnderFive(name);

        this.name = name;
        this.position = 0;
    }

    private void checkIfNameUnderFive(String name) {
        if (name.length() > Constants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
