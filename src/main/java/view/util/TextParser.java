package view.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {

    private TextParser() {
    }

    public static List<String> parseByDelimiter(String text, String delimiter) {
        String[] values = text.split(delimiter);
        return Arrays.stream(values)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
