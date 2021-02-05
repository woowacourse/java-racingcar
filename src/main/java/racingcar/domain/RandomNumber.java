package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();
    private static final int START = 0;
    private static final int END = 10;

    private int number;

    public RandomNumber() {
        this.number = START + RANDOM.nextInt(END - START);
    }
}
