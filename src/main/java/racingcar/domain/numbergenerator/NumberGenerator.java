package racingcar.domain.numbergenerator;

import java.util.Random;

public class NumberGenerator {

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
