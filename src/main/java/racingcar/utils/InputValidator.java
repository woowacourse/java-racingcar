package racingcar.utils;

public class InputValidator {
    private static final String INCORRECT_NUMBER_ERROR = "시도횟수는 숫자여야 합니다.";
    private static final String NO_NAME_ERROR = "반드시 자동차 이름을 입력하셔야 합니다.";
    private static final char COMMA = ',';

    private InputValidator() {}

    public static int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
        }
    }

    public static String validateInputCarNames(String carNames) {
        validateNull(carNames);
        validateComma(carNames);
        return carNames;
    }

    private static void validateNull(String text) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException(NO_NAME_ERROR);
        }
    }

    private static void validateComma(String text) {
        if (text.charAt(text.length() - 1) == COMMA) {
            throw new IllegalArgumentException(NO_NAME_ERROR);
        }
    }
}
