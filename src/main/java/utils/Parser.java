package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<String> parse(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .collect(Collectors.toList());
    }
}
