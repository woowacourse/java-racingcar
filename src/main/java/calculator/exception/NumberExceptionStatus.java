package calculator.exception;

public enum NumberExceptionStatus {

    NUMBER_IS_NEGATIVE("음수를 입력하셨습니다."),
    NUMBER_IS_NOT_NUMERIC("숫자 이외의 값을 입력하셨습니다.");

    private final String message;

    NumberExceptionStatus(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
