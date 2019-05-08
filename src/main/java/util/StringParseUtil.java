package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParseUtil {
    public static List<String> parseStringByComma(String str) {
        return Arrays.asList(str.split(" "));
    }
}
