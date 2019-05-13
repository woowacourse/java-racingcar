package domain;

import java.util.Random;

public class MoveStrategy {
    public static final int MAX_NUM = 10;
    private static final int MOVE_START = 4;

    private final Random random;

    public MoveStrategy(Random random) {
        this.random = random;
    }

    public boolean isMove() {
        return MOVE_START <= random.nextInt(MAX_NUM);
    }
}
