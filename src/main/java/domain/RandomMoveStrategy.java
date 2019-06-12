package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    public static RandomMoveStrategy DEFAULT = new RandomMoveStrategy();

    private static final Random RANDOM = new Random();

    @Override
    public boolean canMove() {
        int num = RANDOM.nextInt(MoveCondition.NUM_TO + 1);

        return MoveCondition.canMove(num);
    }
}
