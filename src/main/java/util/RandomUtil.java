package util;

import java.util.Random;
import racingcar.domain.enums.DomainErrorMessage;

public class RandomUtil {

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
            throw new IllegalStateException(DomainErrorMessage.RANDOM_NUMBER_RANGE_OVER_ERROR_MESSAGE.get());
        }
    }
}
