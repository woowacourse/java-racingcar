package util;

import java.util.Random;

public class RandomUtil {

    private static final String RANDOM_NUMBER_RANGE_OVER_ERROR_MESSAGE = "최소, 최대 범위의 입력을 확인해 주세요";
    private static final Random RANDOM = new Random();

    public static int getRandomNumberBetweenMinimumAndMaximum(int minimum, int maximum) {
        int exclusiveBoundCorrectionValue = 1;
        int randomNumber =
                RANDOM.nextInt(maximum - minimum + exclusiveBoundCorrectionValue) + minimum;
        validateRange(randomNumber, minimum, maximum);
        return randomNumber;
    }

    private static void validateRange(int number, int minimum, int maximum) {
        if (number > maximum || number < minimum) {
            throw new IllegalStateException(RANDOM_NUMBER_RANGE_OVER_ERROR_MESSAGE);
        }
    }
}
