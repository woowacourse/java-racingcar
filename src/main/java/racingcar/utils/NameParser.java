package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    private static final String DELIMITER = ",";

    private NameParser() {
    }

    public static List<String> parse(String rawNames) {
        String[] names = rawNames.split(DELIMITER);
        return Arrays.stream(names)
                .toList();
    }
}
