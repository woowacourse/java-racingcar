package racingcar.domain.movestrategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean canMove() {
        Random random = new Random();
        int number = random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
        return number >= MOVE_CONDITION;
    }
}
