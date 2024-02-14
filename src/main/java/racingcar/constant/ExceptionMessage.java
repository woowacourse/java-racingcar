package racingcar.constant;

public enum ExceptionMessage {
    INVALID_CAR_NAME("이름은 다섯 자 이내로 입력해 주세요."),
    INVALID_ROUND_RANGE("시도 횟수는 1 이상 입력해 주세요."),
    INVALID_ROUND_FORMAT("시도 횟수는 숫자만 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
