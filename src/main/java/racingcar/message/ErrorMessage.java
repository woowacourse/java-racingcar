package racingcar.message;

public enum ErrorMessage {
    INVALID_CAR_NAME("유효하지 않은 자동차 이름입니다."),

    INVALID_ROUND("유효하지 않은 시도 횟수입니다."),
    ;

    private static final String PREFIX = "[ERROR] ";

    private final String value;

    ErrorMessage(final String value) {
        this.value = value;
    }

    public String get() {
        return PREFIX + value;
    }
}
