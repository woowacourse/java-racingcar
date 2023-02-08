package racingcar.constant;

public enum ErrorLog {
    EMPTY_STRING("자동차 이름은 공백일 수 없습니다.");

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
