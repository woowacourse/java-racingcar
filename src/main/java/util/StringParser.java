package util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static final String ERROR_OF_TYPE = "[ERROR] 올바르지 않은 형식의 입력값입니다.";

    public static List<String> split(String target, String delimiter) {
        return Arrays.stream(target.split(delimiter))
                .map(String::trim)
                .toList();
    }

    public static Integer parseToInt(String target) {
        validateNumeric(target);
        return Integer.parseInt(target);
    }

    public static void validateNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_OF_TYPE);
        }
    }
}
