package util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static int CAR_NAME_MAX = 5;

    public static List<String> parseStringByComma(String string) {
        return Arrays.asList(string.split(","));
    }

    public static boolean isCarNameLength(String strings) {
        if (strings.length() > CAR_NAME_MAX) {
            return false;
        }
        return true;
    }
}