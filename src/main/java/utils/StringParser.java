package utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> splitByComma(String input) {
        String[] split = input.split(",");
        return Arrays.asList(split);
    }
}
