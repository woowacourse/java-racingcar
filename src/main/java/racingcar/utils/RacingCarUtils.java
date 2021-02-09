package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class RacingCarUtils {
    private RacingCarUtils() {
    }

    public static List<String> splitInputString(final String inputString) {
        return Arrays.asList(inputString.split(","));
    }
}
