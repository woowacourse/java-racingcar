package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;

    public static void validateCarName(List<String> carNames) {
        validateMinimumCarName(carNames);
        validateCarNameLength(carNames);
    }

    private static void validateMinimumCarName(List<String> carNames) {
        boolean validCarNames = carNames.stream()
                .allMatch(carName -> carName.length() >= MINIMUM_CAR_NAME_LENGTH);
        if (!validCarNames) {
            throw new IllegalArgumentException("자동차 이름에 공백일 수 없습니다.");
        }
    }

    private static void validateCarNameLength(List<String> carNames) {
        boolean validCarNamesLength = carNames.stream()
                .allMatch(carName -> carName.length() <= MAXIMUM_CAR_NAME_LENGTH);
        if (!validCarNamesLength) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public static void validateNameInput(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차가 입력되어야 합니다.");
        }
    }

    public static void validateTrialInput(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도할 횟수는 숫자여야 합니다.");
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
