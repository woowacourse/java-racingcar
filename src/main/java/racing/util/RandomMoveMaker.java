package racing.util;

import java.util.Random;

public class RandomMoveMaker {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MIN_FORWARD_CONDITION = 4;

    private final Random random;

    public RandomMoveMaker(Random random) {
        this.random = random;
    }

    public boolean isMove() {
        return generateRandomNumber() >= MIN_FORWARD_CONDITION;
    }

    public int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
