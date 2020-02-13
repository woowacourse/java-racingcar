package racingcargame.domain;

import java.util.Random;

public class MoveDecider extends Random {

    private static final int BOUND = 10;

    public int getNumber() {
        return nextInt(BOUND);
    }
}
