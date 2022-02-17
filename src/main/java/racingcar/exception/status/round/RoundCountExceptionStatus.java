package racingcar.exception.status.round;

import racingcar.exception.status.ExceptionStatus;

public enum RoundCountExceptionStatus implements ExceptionStatus {

    ROUND_IS_NOT_NUMERIC("숫자여야 합니다."),
    ROUND_IS_NOT_POSITIVE("양수여야 합니다.");

    private static final String MESSAGE_PREFIX = "실행 횟수는 ";
    private final String message;

    RoundCountExceptionStatus(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }

}
