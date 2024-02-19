package racingcar.util;

import java.util.Random;

public interface RandomUtils {
    Random random = new Random();

    default int generate(int minLimit, int maxLimit) {
        return random.nextInt(maxLimit - minLimit) + minLimit;
    }
}
