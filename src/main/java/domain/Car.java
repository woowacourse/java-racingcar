package domain;

import utils.Validator;

public class Car {
    private static final int MIN_MOVE_POWER = 4;
    private final String name;
    private int position;

    public Car(String name) {
        Validator.checkBlank(name);
        Validator.checkLength(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int power) {
        if (power >= MIN_MOVE_POWER) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
