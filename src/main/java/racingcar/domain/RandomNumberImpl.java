package racingcar.domain;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber{
    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
