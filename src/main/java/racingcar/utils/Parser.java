package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String PARSING_EXCEPTION_MESSAGE = "빈 입력입니다.";

    public static List<String> parsing(String text, String delimiter) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException(PARSING_EXCEPTION_MESSAGE);
        }
        return Arrays.asList(text.split(delimiter));
    }
}