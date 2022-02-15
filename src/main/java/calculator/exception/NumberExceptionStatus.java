package calculator.exception;

public enum NumberExceptionStatus {

    NUMBER_IS_NEGATIVE_EXCEPTION_STATUS("음수를 입력하셨습니다."),
    NUMBER_IS_NOT_NUMERIC_EXCEPTION_STATUS("숫자 이외의 값을 입력하셨습니다.");

    private final String message;

    NumberExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
