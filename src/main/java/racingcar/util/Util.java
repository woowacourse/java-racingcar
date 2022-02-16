package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static final String SPLIT_CARS_NAME = ",";
    private static final int SPLIT_LIMIT = -1;

    public static List<String> convertCarsName(String name) {
        return Arrays.stream(name.split(SPLIT_CARS_NAME, SPLIT_LIMIT))
                .collect(Collectors.toList());
    }

    public static int convertToInt(String inputRound) {
        return Integer.parseInt(inputRound);
    }
}
