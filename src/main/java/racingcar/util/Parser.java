package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String DEFAULT_SEPARATOR = ",";

    public static List<String> split(final String text) {
        return Arrays.asList(text.split(DEFAULT_SEPARATOR));
    }
}
