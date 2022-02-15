package racingcar.exception.round.message;

public enum RoundExceptionMessage {

    ROUND_IS_NOT_NUMERIC("이동 횟수는 숫자여야 합니다."),
    ROUND_IS_NOT_POSITIVE("이동 횟수는 양수여야 합니다.");

    private final String message;

    RoundExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
