package racingcar.util;

import java.util.Random;

public class RandomIntGenerator implements IntGenerator {
    private final Random random;

    public RandomIntGenerator() {
        this.random = new Random();
    }

    public int getOneNumber(int min, int max) {
        return random.ints(min, (max + 1))
                .findFirst()
                .getAsInt();
    }
}
