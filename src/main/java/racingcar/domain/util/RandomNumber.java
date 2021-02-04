package racingcar.domain.util;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();

    public static int generate(int bound) {
        return random.nextInt(bound + 1);
    }
}
