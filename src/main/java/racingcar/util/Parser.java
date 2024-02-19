package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SEPARATER= ",";

    public static List<String> parseCarNames(final String input) {
        return Arrays.stream(input.split(SEPARATER))
                .map(String::trim)
                .toList();
    }
}
