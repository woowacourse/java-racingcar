package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGeneratorUtils {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private RandomNumbersGeneratorUtils() {
    }

    public static List<Integer> generateRandomNumbersSizeOf(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(OneRandomNumberGeneratorUtils
                .generateOneRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
        return randomNumbers;
    }
}
