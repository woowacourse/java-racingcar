package racingcar.domain;

import java.util.Random;

public class Engine {
    private static final int RANGE = 10;

    public int ignite() {
        Random random = new Random();
        return random.nextInt(RANGE);
    }
}
