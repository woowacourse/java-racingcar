package util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static List<String> parseStringByComma(String str) {
        return Arrays.asList(str.split(","));
    }

}
