package racingcar.view.utils;

import java.util.Arrays;
import java.util.List;

public class InputUtils {
    private static final String DELIMITER = ",";

    private InputUtils() {
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(DELIMITER, -1)).toList();
    }
}
