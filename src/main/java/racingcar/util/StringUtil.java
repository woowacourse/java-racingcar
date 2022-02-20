package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int SPLIT_WITH_EMPTY = -1;

    public static List<String> split(String input) {
        List<String> elements = Arrays.asList(input.split(CAR_NAME_DELIMITER, SPLIT_WITH_EMPTY));
        return elements;
    }
}
