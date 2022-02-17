package racingcar.util;

public class InputValidator {
    public static void validateBlank(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차가 입력되어야 합니다.");
        }
    }
}
