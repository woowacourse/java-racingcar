package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class CarNameConverter {
    private static final String DELIMITER = ",";

    public static List<String> convertToCarNames(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
