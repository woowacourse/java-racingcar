package racingcar.domain;

import java.util.Random;

public class GoOrStop {
    private static final int NUMBER_POSSIBLE_TO_GO = 4;
    private static final int MAX_RANDOM_NUMBER = 10;

    public static boolean decideToGo() {
        boolean possibleToGo = false;

        if (generateRandomNumber() >= NUMBER_POSSIBLE_TO_GO) {
            possibleToGo = true;
        }

        return possibleToGo;
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
