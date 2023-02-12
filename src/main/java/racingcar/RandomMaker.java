package racingcar;

import java.util.Random;

public class RandomMaker {

    private static final int MAXIMUM_VALUE = 10;
    private static Random random = new Random();

    public static int random() {
        return random.nextInt(MAXIMUM_VALUE);
    }
}
