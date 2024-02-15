package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarNames {
    private List<String> names;

    public RacingCarNames(String names) {
        List<String> splitNames = splitCarNames(names);
        validateDuplication(splitNames);
        validateNamesLength(splitNames);
        this.names = splitNames;
    }

    public RacingCars createRacingCars() {
        return new RacingCars(names.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList()));
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
