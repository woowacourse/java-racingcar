package racingcar.utils;

import java.util.Arrays;

public class StringSeparator {
    public static final String COMMA = ",";

    public static String[] splitAndTrim(String names) {
        String[] splitNames = names.split(COMMA);
        Arrays.setAll(splitNames, i -> splitNames[i].trim());
        return splitNames;
    }
}
