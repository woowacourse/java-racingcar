package racingcar.domain;

import java.util.Random;

public class GoOrStop {

    public static boolean decideGoOrStop() {
        boolean possibleToGo = false;

        if (generateRandomNumber() >= 4) {
            possibleToGo = true;
        }

        return possibleToGo;
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
