package racing.util;

import java.util.List;

public class Converter {
    public static List<String> splitInput(String input) {
        return List.of(input.split(","));
    }

    public static int convertType(String input) {
        return Integer.parseInt(input);
    }
}
