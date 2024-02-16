package util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> split(String target, String delimiter) {
        return Arrays.stream(target.split(delimiter)).toList();
    }

    public static Integer parseToInt(String target) {
        validateNumeric(target);
        return Integer.parseInt(target);
    }

    public static void validateNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식의 입력값입니다.");
        }
    }
}
