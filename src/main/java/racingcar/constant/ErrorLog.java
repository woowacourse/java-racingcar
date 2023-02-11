package racingcar.constant;

public enum ErrorLog {
    EMPTY_STRING("자동차 이름은 공백일 수 없습니다."),
    NOT_NATURAL_NUMBER("시도 횟수는 자연수여야 합니다."),
    INVALID_NAME_LENGTH("자동차 이름은 공백 포함 5자 이하만 가능합니다."),
    INVALID_VALUE("이동 조건의 범위에 맞지 않습니다."),
    OVER_FINAL_ROUND_NUMBER("시도할 횟수를 초과한 자동차가 있습니다.");

    private final String ERROR_MARKER = "[ERROR]";
    private final String SPACE = " ";

    private final String message;

    ErrorLog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MARKER + SPACE + message;
    }
}
