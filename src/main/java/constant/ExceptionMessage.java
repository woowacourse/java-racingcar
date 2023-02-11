package constant;

public enum ExceptionMessage {

    EXCEPTION_MESSAGE("자동차 이름은 1~5자 이내의 이름으로 입력하여야 합니다."),
    EXCEPTION_SPACE_MESSAGE("자동차 이름은 공백만 입력 불가능합니다."),
    EXCEPTION_NOT_NUMBER_MESSAGE("시도 횟수는 숫자로만 입력하여야 합니다."),
    EXCEPTION_TRY_COUNT_MESSAGE("시도 횟수는 1이상 입력하여야 합니다.");

    private final String TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = TAG + exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
