package domain;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> splitByComma(String input) {
        String[] split = input.split(",", -1);
        return Arrays.asList(split);
    }
}
