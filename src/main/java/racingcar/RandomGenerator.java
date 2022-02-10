package racingcar;

import java.util.Random;

public class RandomGenerator {

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
