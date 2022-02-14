package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

import static racingcar.constant.ErrorMessage.*;

public class RacingGameValidationUtil {

    private RacingGameValidationUtil() {
    }

    public static void isDuplicated(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

}
