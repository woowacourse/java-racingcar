package racingcar.domian;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_MAX_LIMIT_NUMBER = 10;
    private static final int RANDOM_MIN_LIMIT_NUMBER = 0;
    private static final int LIMIT_FOR_MOVE = 4;

    private static final Random random = new Random();

    private static int randomNumber;

    RandomNumber() {
        int randomNumber = generateRandom();
        if(validateRandomNumber(randomNumber)){
            this.randomNumber = randomNumber;
        }
    }

    private static int generateRandom() {
        return random.nextInt(RANDOM_MAX_LIMIT_NUMBER);
    }

    private boolean validateRandomNumber(int randomNumber) {
        return randomNumber >= RANDOM_MIN_LIMIT_NUMBER && randomNumber < RANDOM_MAX_LIMIT_NUMBER;
    }

    public static boolean isMovable() {
        return randomNumber >= LIMIT_FOR_MOVE;
    }

}
