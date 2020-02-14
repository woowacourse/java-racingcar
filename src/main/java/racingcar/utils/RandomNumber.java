package racingcar.utils;

import java.util.Random;

import racingcar.domain.RandomNo;

public class RandomNumber {
    private static final int maxRange = 10;

    private RandomNumber() {
    }

    public static RandomNo generateRandomIntIntRange() {
        Random r = new Random();
        return new RandomNo(r.nextInt(maxRange));
    };
}
