package utils;

import java.util.List;

public class InputStringParser {
    public static List<String> parseInputToList(String input) {
        String[] names = input.split(",");
        return List.of(names);
    }
}
