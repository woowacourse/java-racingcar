package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    public static int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
