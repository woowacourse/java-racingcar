package racingcar.exception;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력 값은 숫자여야 합니다."),
    INVALID_CAR_NAME_LENGTH("유효하지 않은 자동차 이름입니다."),
    INVALID_RACE_COUNT_RANGE("유효하지 않은 시도 횟수입니다.")
    ;
    
    private final String message;
    
    ErrorMessage(final String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
