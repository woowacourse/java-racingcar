package racingcar.utils;

import java.util.Random;

import racingcar.domain.MoveNumber;

public class RandomNumber {
    private static final int MAX_RANGE = 10;
    private static final Random random = new Random();

    private RandomNumber() {
    }

    public static MoveNumber generateRandomIntIntRange() {
        return new MoveNumber(random.nextInt(MAX_RANGE));
    }
}
