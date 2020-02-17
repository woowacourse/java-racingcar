package racingcar.domain;

import java.util.Random;

public class RandomNumber implements NumberGenerator {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int NUMBER_POSSIBLE_TO_GO = 4;

    private Random random = new Random();

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER + 1);
    }

    public static boolean canMove(int randomNumber) {
        return randomNumber >= NUMBER_POSSIBLE_TO_GO;
    }

    @Override
    public int generateNumber() {
        return generateRandomNumber();
    }
}
