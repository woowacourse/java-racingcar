package racingcar.domain.util;

import java.util.Random;

public class RandomNumber implements RandomUtils<Integer> {
    private static final Random random = new Random();

    @Override
    public Integer generate(int bound) {
        int randomNumber = random.nextInt(bound + 1);

        return randomNumber;
    }
}