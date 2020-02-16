package racingcar.domain;

import java.util.Random;

public class MakeRandomNumber {
    private static final int MAX_RANGE = 10;
    private static final Random r = new Random();

    public static int generateRandomIntIntRange() {
        return r.nextInt(MAX_RANGE);
    }
}
