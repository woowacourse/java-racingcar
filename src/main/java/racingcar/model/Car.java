package racingcar.model;

import racingcar.constants.Constants;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        nameUnderFive(name);
    }

    private static void nameUnderFive(String name) {
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

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(position));
    }
}
