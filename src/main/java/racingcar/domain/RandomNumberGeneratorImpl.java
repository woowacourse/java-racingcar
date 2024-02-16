package racingcar.domain;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
