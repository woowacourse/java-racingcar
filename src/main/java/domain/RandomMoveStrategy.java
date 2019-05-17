package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    public static final int START_NUM = 0;
    public static final int MAX_NUM = 10; // [0, MAX_NUM)
    public static final int MOVE_START = 4;

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return MOVE_START <= (START_NUM + random.nextInt(MAX_NUM - START_NUM));
    }
}
