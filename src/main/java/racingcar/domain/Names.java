package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DUPLICATE_NAME = ERROR_PREFIX + "이름이 중복되었습니다";
    private static final String COMMA = ",";
    private static final String WHITESPACE = " ";
    private static final String EMPTY = "";
    private List<Name> names;

    public Names(String names) {
        List<Name> carNames = splitNames(names);
        isDuplicate(carNames);
        this.names = carNames;
    }

    private void isDuplicate(List<Name> carNames) {
        boolean duplicated = carNames.stream()
                .distinct()
                .count() != carNames.size();

        if (duplicated) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    private List<Name> splitNames(String names) {
        return Stream.of(names.split(COMMA))
                .map(s -> s.replaceAll(WHITESPACE, EMPTY))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return names;
    }
}
