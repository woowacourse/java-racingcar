package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private Util() {
    }

    public static List<String> splitWithDelimiter(String value, String delimiter) {
        return Arrays.stream(value.split(delimiter, -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
