package racingcar.util;

import static racingcar.constants.SystemConstants.TEN;

public class RandomUtils {

    public static int generateNumber() {
        return (int) (Math.random() * TEN);
    }
}
