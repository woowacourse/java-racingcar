package racingcar.util;

import java.util.Random;
import racingcar.view.ErrorMessage;

public class RandomUtil {

    private static final int EXCLUSIVE_BOUND_CORRECTION_VALUE = 1;
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 9;

    private static final Random RANDOM = new Random();

    public static int generateRandomNumber() {
        int randomNumber =
                RANDOM.nextInt(MAXIMUM - MINIMUM + EXCLUSIVE_BOUND_CORRECTION_VALUE) + MINIMUM;
        validRange(randomNumber);
        return randomNumber;
    }

    private static void validRange(int randomNumber) {
        if (randomNumber > MAXIMUM || randomNumber < MINIMUM) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_OVER.toString());
        }
    }
}
