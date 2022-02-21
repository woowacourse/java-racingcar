package racingcar.utils;

import java.util.Arrays;

public class StringSeparator {
    private static final String NAMES_DELIMITER = ",";

    public static String[] splitAndTrim(String names) {
        String[] splitNames = names.split(NAMES_DELIMITER);
        Arrays.setAll(splitNames, i -> splitNames[i].trim());
        return splitNames;
    }
}
