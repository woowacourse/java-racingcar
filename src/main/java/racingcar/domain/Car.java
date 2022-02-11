package racingcar.domain;

import java.util.Random;

public class Car {
    private static final String INFO_BETWEEN_WORD = " : ";
    private static final String POSITION_WORD = "-";
    private static final int RANDOM_MAX_RANGE = 10;
    private static final int RANDOM_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward() {
        Random random = new Random();

        if (random.nextInt(RANDOM_MAX_RANGE) >= RANDOM_CONDITION) {
            position += 1;
        }
    }

    @Override
    public String toString() {
        String info = name + INFO_BETWEEN_WORD;

        for (int i = 0; i < position; i++) {
            info += POSITION_WORD;
        }

        return info;
    }
}
