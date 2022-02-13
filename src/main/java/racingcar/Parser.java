package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> split(String text) {
        return Arrays.asList(text.split(","));
    }
}
