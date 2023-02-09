package racingcar.util;

import java.util.Random;

public class RandomIntGenerator {
    private Random random;

    public RandomIntGenerator() {
        this.random = new Random();
    }

    public int getByRange(int min, int max) {
        return random.ints(min, (max + 1))
                .findFirst()
                .getAsInt();
    }
}
