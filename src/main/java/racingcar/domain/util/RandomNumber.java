package racingcar.domain.util;

import racingcar.exception.MoveConditionOutOfBoundException;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();

    public static int generate(int bound) {
        int randomNumber = random.nextInt(bound + 1);

        if (randomNumber > bound) {
            throw new MoveConditionOutOfBoundException();
        }

        return randomNumber;
    }
}