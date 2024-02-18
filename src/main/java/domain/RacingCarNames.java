package domain;

import java.util.List;

public class RacingCarNames {
    private static final int NAME_LENGTH = 5;
    private static final String DELIMITER = ",";
    private final List<String> names;

    public RacingCarNames(final String names) {
        List<String> splitNames = splitCarNames(names);
        validateDuplication(splitNames);
        validateNamesLength(splitNames);
        this.names = splitNames;
    }

    public List<String> getNames() {
        return names;
    }

    private void validateNamesLength(final List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(final String name) {
        if (name.isBlank() || name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    private List<String> splitCarNames(final String input) {
        return List.of(input.split(DELIMITER));
    }

    private void validateDuplication(final List<String> racingCarNames) {
        if (isDuplicated(racingCarNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private boolean isDuplicated(final List<String> racingCarNames) {
        return racingCarNames.stream().distinct().count() < racingCarNames.size();
    }
}
