package view;

public class ValidationView {
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 1이상 5이하만 가능합니다";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "음수 혹은 문자를 입력하였습니다.";
    private static final String MIN_ROUND_NUMBER_ERROR_MESSAGE = "1이상의 숫자만 입력해야 합니다.";

    public static void printNameErrorMessage() {
        System.out.println(NAME_LENGTH_ERROR_MESSAGE);
    }

    public static void printNotIntegerErrorMessage() {
        System.out.println(NOT_INTEGER_ERROR_MESSAGE);
    }

    public static void printMinRoundNumberErrorMessage() {
        System.out.println(MIN_ROUND_NUMBER_ERROR_MESSAGE);
    }
}
