package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    private RandomUtil() {}

    public static int getNumbersInRange(int endExclusive) {
        return random.nextInt(endExclusive);
    }

    public static List<Integer> getRandomNumbers(int amount, int endExclusive) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            randomNumbers.add(getNumbersInRange(endExclusive));
        }
        return randomNumbers;
    }
}
