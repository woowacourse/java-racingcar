package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> parse(String input) {
        String[] split = input.split(",");
        return Arrays.asList(split);
    }
}
