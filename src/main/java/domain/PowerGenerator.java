package domain;

import java.util.Random;

public class PowerGenerator {

    private static final Integer MIN = 0;
    private static final Integer MAX = 9;

    public Integer makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1);
    }
}
