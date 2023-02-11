package utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> splitByComma(final String input) {
        String[] split = input.split(",", -1);
        return Arrays.asList(split);
    }
}
