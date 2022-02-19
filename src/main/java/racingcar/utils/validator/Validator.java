package racingcar.utils.validator;

public class Validator {
    private static final String EMPTY_INPUT_MESSAGE = "시도 횟수에 빈 문자열은 입력될 수 없습니다.";
    private static final String NULL_INPUT_MESSAGE = "NULL을 입력할 수 없습니다.";

    public static void checkNull(String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException(NULL_INPUT_MESSAGE);
        }
    }

    public static void checkEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.isBlank();
    }
}
