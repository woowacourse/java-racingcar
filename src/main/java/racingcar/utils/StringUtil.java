package racingcar.utils;

import java.util.List;

public class StringUtil {

    private static final int SPLIT_LIMIT = -1;
    private static final String SPLIT_DELIMITER = ",";

    private StringUtil() {
    }

    public static List<String> toList(final String name) {
        return List.of(name.split(SPLIT_DELIMITER, SPLIT_LIMIT));
    }
}
