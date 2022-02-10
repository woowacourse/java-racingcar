package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNameHandler {
    public static List<Name> createNames(String input) {
        String[] split = splitByComma(input);
        validateDuplicate(split);

        return Arrays.stream(split)
            .map(Name::of)
            .collect(Collectors.toList());
    }

    private static String[] splitByComma(String input) {
        return input.split(",");
    }

    private static void validateDuplicate(String[] names) {
        if (names.length != distinctCount(names)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static long distinctCount(String[] names) {
        return Arrays.stream(names).distinct().count();
    }
}
