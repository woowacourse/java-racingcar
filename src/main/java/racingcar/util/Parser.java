package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseCarNames(final String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }
}
