package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

public class RacingGameValidationUtil {

    private static final String DUPLICATED = "[ERROR] 중복된 자동차 이름은 허용되지 않습니다.";

    private RacingGameValidationUtil() {
    }

    public static void isDuplicated(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

}
