package racingcar.util;

import java.util.List;

public class InputValidator {
    public static void validateBlank(String carNames) {
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
