package constant;

public enum ExceptionMessage {
    CAR_NAME_NOT_INPUT_MESSAGE("자동차 이름을 입력해주세요."),
    CAR_NAME_WRONG_LENGTH_MESSAGE("자동차 이름은 1~5자 이내의 이름으로 입력하여야 합니다."),
    CAR_NAME_BLANK_MESSAGE("자동차 이름은 공백만 입력하는 것이 불가능합니다."),
    TRY_COUNT_NOT_NUMBER_MESSAGE("시도 횟수는 숫자로만 입력하여야 합니다."),
    TRY_COUNT_NOT_POSITIVE_MESSAGE("시도 횟수는 1이상 입력하여야 합니다.");

    private final String TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = TAG + exceptionMessage + System.lineSeparator();
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
