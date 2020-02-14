package racingcar.utils;

import java.util.Random;

import racingcar.domain.RandomNo;

public class RandomNumber {
    private static final int maxRange = 10;
    private static final Random random = new Random();

    private RandomNumber() {
    }

    public static RandomNo generateRandomIntIntRange() {
        return new RandomNo(random.nextInt(maxRange));
    }
}
