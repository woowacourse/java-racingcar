package domain;

import java.util.Random;

public class MoveStrategy {
    public static final int MAX_NUM = 10;
    public static final int MOVE_START = 4;

    private Random random = new Random();


    public boolean isMove() {
        return MOVE_START <= random.nextInt(MAX_NUM);
    }
}
