package domain.movestrategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_BOUNDARY_NUMBER = 4;
    private static final Random random= new Random();

    @Override
    public boolean willMove() {
        int randomNumber = random.nextInt(RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
