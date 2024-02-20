package exception.view;

public enum InputException {
    INVALID_FORMAT("[ERROR] 입력 형식이 올바르지 않습니다. 다시 입력해 주세요."),
    INVALID_LENGTH("[ERROR] 이름의 길이는 1자 이상, 5자 이하여야 합니다. 다시 입력해 주세요."),
    NOT_INTEGER("[ERROR] 시도 횟수는 정수여야 합니다. 다시 입력해 주세요.");

    private final String exceptionMessage;

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
