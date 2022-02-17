package calculator.enums;

public enum ErrorMessage {
    NONE_INTEGER_ERROR_MESSAGE("숫자가 아닌 입력입니다. 구분자를 이용해서 숫자를 입력해주세요."),
    NEGATIVE_VALUE_ERROR_MESSAGE("음수 값을 입력했습니다. 양수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
