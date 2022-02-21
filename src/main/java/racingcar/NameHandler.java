package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.vo.Name;

public class NameHandler {
    private static final String NAME_DELIMITER = ",";

    private NameHandler() {}

    public static List<Name> stringToNames(String names) {
        return convertArrayToNames(splitByComma(names));
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
