package racingcar.domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void move(MovableStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
    }
}
