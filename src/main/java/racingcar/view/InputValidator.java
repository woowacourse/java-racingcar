package racingcar.view;

public class InputValidator {
    private static final String ERROR_GET_INTEGER_MESSAGE = "입력 받은 값이 올바른 숫자 값이 아닙니다.";
    private static final String ERROR_GET_POSITIVE_MESSAGE = "양수를 입력해주세요.";
    private static final String ERROR_GET_NOT_EMPTY_MESSAGE = "빈 값을 입력하셨습니다. 양수를 입력해주세요.";

    public static void validIterationNo(String input) {
        validEmptyInput(input);
        validInteger(input);
        validPositiveInput(input);
    }

    private static void validEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException(ERROR_GET_NOT_EMPTY_MESSAGE);
        }
    }

    private static void validInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_GET_INTEGER_MESSAGE);
        }
    }

    private static void validPositiveInput(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new RuntimeException(ERROR_GET_POSITIVE_MESSAGE);
        }
    }
}
