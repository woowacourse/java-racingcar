package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String ERROR_DUPLICATED_CAR_NAME_MESSAGE = "중복값을 입력할 수 없습니다.";
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public static Names from(List<String> names) {
        validateNames(names);
        return new Names(names.stream()
                .map(Name::from)
                .collect(Collectors.toList()));
    }

    private static void validateNames(List<String> names) {
        checkNamesDuplicated(names);
    }

    private static void checkNamesDuplicated(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAME_MESSAGE);
        }
    }

    public List<Name> getNames() {
        return this.names;
    }
}
