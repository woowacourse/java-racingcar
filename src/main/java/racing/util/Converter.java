package racing.util;

import java.util.Arrays;
import java.util.List;

public class Converter {
    public static List<String> splitInput(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
