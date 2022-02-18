package racingcar.view;

public class Validator {

    public static void validateCarNames(String carNames) {
        checkCarNamesEmpty(carNames);
    }

    private static void checkCarNamesEmpty(String stringNames) {
        if (stringNames == null || stringNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 값이 존재해야한다.");
        }
    }

    public static void validateTryCount(String tryCountText) {
        checkTryCountInteger(tryCountText);
    }

    private static void checkTryCountInteger(String tryCountText) {
        try {
            Integer.parseInt(tryCountText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자이어야 합니다.");
        }
    }

}
