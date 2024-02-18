package exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열을 입력할 수 없습니다. 다시 입력해주세요."),
    INVALID_COUNT_ERROR("올바르지 않는 반복 횟수입니다. 다시 입력해주세요."),
    INVALID_NAME_ERROR("올바르지 않는 자동차 이름입니다. 다시 입력해주세요."),
    DUPLICATED_NAME_ERROR("중복되는 자동차 이름이 있습니다. 다시 입력해주세요."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
