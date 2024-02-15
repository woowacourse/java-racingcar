package domain;

import java.util.List;

public class RacingCarNames {
    private List<String> names;

    public RacingCarNames(String names) {
        List<String> splitNames = splitCarName(names);
        checkCarNameDuplication(splitNames);
        validateNamesLength(splitNames);
        this.names = splitNames;
    }

    private void validateNamesLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    private List<String> splitCarName(String input) {
        List<String> names = List.of(input.split(","));
        return names;
    }

    private void checkCarNameDuplication(List<String> racingCarNames) {
        if (isDuplicated(racingCarNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private boolean isDuplicated(List<String> racingCarNames) {
        return racingCarNames.stream().distinct().count() < racingCarNames.size();
    }
}
