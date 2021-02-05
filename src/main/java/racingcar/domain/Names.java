package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DUPLICATE_NAME = ERROR_PREFIX + "이름이 중복되었습니다";
    private static final String COMMA = ",";
    private List<Name> names;

    public Names(String names) {
        List<Name> carNames = Arrays.stream(splitNames(names))
                .map(Name::new)
                .collect(Collectors.toList());
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

    private String[] splitNames(String names) {
        String[] carNames = Stream.of(names.split(COMMA))
                .toArray(String[]::new);
        return carNames;
    }

    public List<Name> getNames() {
        return names;
    }
}
