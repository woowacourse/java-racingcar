package racingcar.util;

public class InputValidator {

    private InputValidator() {
        throw new AssertionError();
    }

    public static void validateBlank(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("최소 1개 이상의 글자가 입력되어야 합니다.");
        }
    }
}
