package racingcar.domain.numbergenerator;

import java.util.Random;

public class NumberGenerator {

    private static final int MAX_VALUE_OF_RANDOM_RANGE = 9;

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE_OF_RANDOM_RANGE);
    }
}
