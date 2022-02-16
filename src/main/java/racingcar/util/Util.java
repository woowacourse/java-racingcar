package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<String> splitWithDelimiter(String value, String delimiter) {
        return Arrays.stream(value.split(delimiter))
                .collect(Collectors.toList());
    }

    public static int convertToInt(String inputRound) {
        return Integer.parseInt(inputRound);
    }
}
