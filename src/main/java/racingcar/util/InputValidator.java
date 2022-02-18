package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 5;

    public static void validateCarNameLength(List<String> carNames) {
        if (isCarNameLengthLongerThan5(carNames)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private static boolean isCarNameLengthLongerThan5(List<String> carNames) {
            return carNames.stream()
                    .anyMatch(carName -> carName.length() > MINIMUM_CAR_NAME_LENGTH);
    }

    public static void validateEmptyCarName(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름이 존재하지 않습니다.");
        }
    }

    public static void validateNameInput(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차가 입력되어야 합니다.");
        }
    }

    public static void validateDuplicateName(List<String> carNames) {
        long distinctNum = carNames.stream()
                .distinct()
                .count();

        if (distinctNum != carNames.size()) {
            throw new IllegalArgumentException("자동차의 이름에 중복이 포함되면 안됩니다.");
        }
    }
}
