package racingcar.exception.status.round;

import racingcar.exception.status.ExceptionStatus;

public enum RoundCountExceptionStatus implements ExceptionStatus {

    ROUND_IS_NOT_NUMERIC("이동 횟수는 숫자여야 합니다."),
    ROUND_IS_NOT_POSITIVE("이동 횟수는 양수여야 합니다.");

    private final String message;

    RoundCountExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
