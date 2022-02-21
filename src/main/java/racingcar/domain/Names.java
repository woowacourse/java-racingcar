package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String ERROR_DUPLICATED_CAR_NAME_MESSAGE = "중복값을 입력할 수 없습니다.";

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names fromInput(List<String> names) {
        return new Names(names.stream()
                .map(Name::from)
                .collect(Collectors.toList()));
    }

    public static Names from(List<Name> names) {
        validateNames(names);
        return new Names(names);
    }

    private static void validateNames(List<Name> names) {
        checkNamesDuplicated(names);
    }

    private static void checkNamesDuplicated(List<Name> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAME_MESSAGE);
        }
    }

    public List<Name> getNames() {
        return this.names;
    }
}
