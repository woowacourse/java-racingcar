package racingcar.utils;

import java.util.Arrays;

public class StringSeparator {
    private static final String STRING_DELIMITER = ",";

    public static String[] splitAndTrim(String names) {
        String[] splitNames = names.split(STRING_DELIMITER);
        Arrays.setAll(splitNames, i -> splitNames[i].trim());
        return splitNames;
    }
}
