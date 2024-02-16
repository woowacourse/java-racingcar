package domain;

import java.util.List;

public class RacingCarFactory {
    private final List<String> names;

    public RacingCarFactory(String names) {
        List<String> splitNames = splitCarNames(names);
        validateDuplication(splitNames);
        validateNamesLength(splitNames);
        this.names = splitNames;
    }

    public List<RacingCar> create() {
        return names.stream().map(RacingCar::new).toList();
    }

    private void validateNamesLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private void validateDuplication(List<String> racingCarNames) {
        if (isDuplicated(racingCarNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private boolean isDuplicated(List<String> racingCarNames) {
        return racingCarNames.stream().distinct().count() < racingCarNames.size();
    }
}
