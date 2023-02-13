package domain;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int DIGIT_BOUND = 10;
    private static final int MIN_MOVE_NUM = 4;
    private static final Random random = new Random();

    @Override
    public boolean doMove() {
        int randomValue = random.nextInt(DIGIT_BOUND);
        return randomValue >= MIN_MOVE_NUM;
    }
}
