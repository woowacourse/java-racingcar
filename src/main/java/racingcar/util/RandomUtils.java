package racingcar.util;

import static racingcar.constants.SystemConstants.NUMBER_TEN_FOR_RANDOM;

public class RandomUtils {

    public static int generateNumber() {
        return (int) (Math.random() * NUMBER_TEN_FOR_RANDOM);
    }
}
