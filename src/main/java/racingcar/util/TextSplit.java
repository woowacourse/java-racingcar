package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface TextSplit {

    static List<String> split(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter)).collect(Collectors.toList());
    }
}
