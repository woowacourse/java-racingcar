package racingcar.model;

import static racingcar.utils.NameValidator.*;

import racingcar.utils.NumberGenerator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public void forward(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (number >= 4) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }

    private static void checkNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_MESSAGE);
        }
    }
}
