package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.vo.Name;

public class InputNameHandler {
    private static final String NAME_DELIMITER = ",";

    private InputNameHandler() {}

    public static List<Name> inputToNames(String input) {
        return convertArrayToNames(splitByComma(input));
    }

    private static List<Name> convertArrayToNames(String[] names) {
        validateDuplicateName(names);

        return Arrays.stream(names)
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private static String[] splitByComma(String input) {
        return input.split(NAME_DELIMITER);
    }

    private static void validateDuplicateName(String[] names) {
        if (names.length != distinctCount(names)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static long distinctCount(String[] names) {
        return Arrays.stream(names).distinct().count();
    }
}
