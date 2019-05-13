package util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final int CAR_NAME_MIN = 1;
    private static final int CAR_NAME_MAX = 5;

    public static boolean isCarNameLength(String string) {
        return (CAR_NAME_MIN <= string.length())
                && (string.length() <= CAR_NAME_MAX);
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