package utils;

import java.util.ArrayList;
import java.util.List;

public class InputStringParser {
    public static List<String> parseInputToList(String input) {
        String[] names = input.split(",");
        return new ArrayList<>(List.of(names));
    }
}
