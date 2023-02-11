package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class SplitStringByComma {
    public static List<String> splitByComma(String carNames) {
        String[] splitCarNames = carNames.split("\\s*,\\s*");
        return Arrays.asList(splitCarNames);
    }
}
