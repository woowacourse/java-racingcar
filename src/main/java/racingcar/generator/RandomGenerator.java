package racingcar.generator;

import java.util.Random;

public class RandomGenerator implements IntegerGenerator {
    @Override
    public int generate() {
        return new Random().nextInt(10);
    }
}
