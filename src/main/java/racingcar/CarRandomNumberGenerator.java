package racingcar;

import java.util.Random;

public class CarRandomNumberGenerator implements CarNumberGenerator {

    private static final int MAX_RANDOM_INT = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_INT);
    }
}
