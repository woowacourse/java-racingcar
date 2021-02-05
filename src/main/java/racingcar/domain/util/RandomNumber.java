package racingcar.domain.util;

import racingcar.exception.MoveConditionOutOfBoundException;

import java.util.Random;

public class RandomNumber {
    private static final int MINIMUM = 0;

    private static final Random random = new Random();

    public static int generate(int bound) {
        int randomNumber = random.nextInt(bound + 1);

        if (!(MINIMUM <= randomNumber && randomNumber <= bound)) {
            throw new MoveConditionOutOfBoundException();
        }

        return randomNumber;
    }
}