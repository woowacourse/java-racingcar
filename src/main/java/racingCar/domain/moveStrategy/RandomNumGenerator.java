package racingCar.domain.moveStrategy;

import java.util.Random;

public class RandomNumGenerator implements NumGenerator {
    private static final int RANDOM_NUM_UPPER_BOUND = 10;
    private static final Random RANDOM = new Random();

    public int generate() {
        return RANDOM.nextInt(RANDOM_NUM_UPPER_BOUND);
    }
}
