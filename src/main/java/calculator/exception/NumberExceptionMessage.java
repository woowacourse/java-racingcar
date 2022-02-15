package calculator.exception;

public enum NumberExceptionMessage {

    NUMBER_IS_NEGATIVE_EXCEPTION_MESSAGE("음수를 입력하셨습니다."),
    NUMBER_IS_NOT_NUMERIC("숫자 이외의 값을 입력하셨습니다.");

    private final String message;

    NumberExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
