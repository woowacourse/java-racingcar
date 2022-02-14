package racingcar.utils;

import java.util.Arrays;

public class StringSeparator {
    private static final String CAR_NAMES_DELIMITER = ",";

    public static String[] splitAndTrim(String names) {
        String[] splitNames = names.split(CAR_NAMES_DELIMITER);
        Arrays.setAll(splitNames, i -> splitNames[i].trim());
        return splitNames;
    }
}
