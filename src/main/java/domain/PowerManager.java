package domain;

import java.util.Random;

public class PowerManager {

    private static final Integer MIN = 0;
    private static final Integer MAX = 9;
    private static final Integer THRESHOLD = 4;

    public Integer generatePower() {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1);
    }

    public boolean isSufficientPower(int power) {
        return THRESHOLD <= power;
    }
}
