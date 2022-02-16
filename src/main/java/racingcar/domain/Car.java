package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward(int randomNum) {
        if (randomNum >= RANDOM_CONDITION) {
            position += 1;
        }
    }

    public boolean checkPosition(int maxPosition) {
        if (position == maxPosition) {
            return true;
        }
        return false;
    }
}
