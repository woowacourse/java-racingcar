package util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> parseStringByComma(String string) {
        return Arrays.asList(string.split(","));
    }
}