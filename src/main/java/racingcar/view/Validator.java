package racingcar.view;

public class Validator {

    public static void validateCarNames(final String carNames) {
        checkCarNamesEmpty(carNames);
    }

    private static void checkCarNamesEmpty(final String stringNames) {
        if (stringNames == null || stringNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 값이 존재해야한다.");
        }
    }

    public static void validateTryCount(final String tryCountText) {
        checkTryCountInteger(tryCountText);
    }

    private static void checkTryCountInteger(final String tryCountText) {
        try {
            Integer.parseInt(tryCountText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자이어야 합니다.");
        }
    }

}
