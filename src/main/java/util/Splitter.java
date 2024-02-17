package util;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    public static List<String> splitWithComma(String originalString) {
        return Arrays.stream(originalString.split(","))
                     .toList();
    }
}
