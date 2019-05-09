package racingcar.domain;

import java.util.Random;

public class RandomMovement implements MovementStrategy {
    static final int MOVE_THRES = 4;
    static final int MAX_RAND = 10;

    public boolean isMovable() {
        Random random = new Random();
        return random.nextInt(MAX_RAND) >= MOVE_THRES;
    }
}