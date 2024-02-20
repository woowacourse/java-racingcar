package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarNames {
    private List<String> names;

    public RacingCarNames(String input) {
        validateLastComma(input);
        List<String> inputNames = List.of(input.split(","));
        validateDuplication(inputNames);
        validateNamesLength(inputNames);
        this.names = inputNames;
    }

    public RacingCars createRacingCars() {
        return new RacingCars(names.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList()));
    }

    private static void validateLastComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하만 가능합니다.");
        }
    }

    private void validateNamesLength(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하만 가능합니다.");
        }
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
