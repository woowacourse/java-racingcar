package racingGame;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public static void validateInput(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    public static List<String> splitInput(String value) {
        String[] names = value.split(",");
        return Arrays.asList(names);
    }

    public static void validateInputList(List<String> values) {
        values.stream().forEach((x) -> validateInput(x));
    }

    public static void validateInputNumberType(String value) {
        try {
            int repeat = Integer.parseInt(value);
            if (repeat <= 0) {
                throw new IllegalArgumentException("횟수는 1이상의 정수만 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 1이상의 정수만 가능합니다.");
        }
    }
}
