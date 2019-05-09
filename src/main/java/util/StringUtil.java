package util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static int CAR_NAME_MAX = 5;

    public static List<String> parseStringByComma(String str) {
        return Arrays.asList(str.split(","));
    }

    public static boolean isCarNameLength(String carName) {
        return carName.length() <= CAR_NAME_MAX;
    }
}
