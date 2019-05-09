package util;

import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class StringUtils {
    private static final int CAR_NAME_MAX = 5;

    public static List<String> parseStringByComma(String string) {
        return Arrays.asList(string.split(","));
    }

    public static boolean isCarNameLength(String string) {
        return string.length() <= CAR_NAME_MAX;
    }

    public static boolean isNumberString(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}