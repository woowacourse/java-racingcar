package racingcar.domain;

import java.util.Random;

public class GoOrStop {

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
