package racingcar.domain.movestrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean canMoveForward() {
        Random random = new Random();
        int number = random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
        return number >= MOVE_CONDITION;
    }
}
