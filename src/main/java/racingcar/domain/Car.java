package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_MAX_RANGE = 10;
    private static final int RANDOM_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        Random random = new Random();

        if (random.nextInt(RANDOM_MAX_RANGE) >= RANDOM_CONDITION) {
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
