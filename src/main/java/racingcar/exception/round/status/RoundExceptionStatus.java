package racingcar.exception.round.status;

public enum RoundExceptionStatus {

    ROUND_IS_NOT_NUMERIC_EXCEPTION_STATUS("이동 횟수는 숫자여야 합니다."),
    ROUND_IS_NOT_POSITIVE_EXCEPTION_STATUS("이동 횟수는 양수여야 합니다.");

    private final String message;

    RoundExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
