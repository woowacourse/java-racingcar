package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersUtils {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;

    public static List<Integer> createRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(createRandomNumber());
        }
        return randomNumbers;
    }

    private static int createRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }
}
