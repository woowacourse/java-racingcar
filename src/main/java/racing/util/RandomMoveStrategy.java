package racing.util;

import java.util.Random;

public class RandomMoveStrategy implements MovableStrategy {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MIN_FORWARD_CONDITION = 4;

    @Override
    public boolean isMove() {
        return generateRandomNumber() >= MIN_FORWARD_CONDITION;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
