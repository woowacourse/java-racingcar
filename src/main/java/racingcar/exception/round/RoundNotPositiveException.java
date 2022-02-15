package racingcar.exception.round;

import static racingcar.exception.round.status.RoundExceptionStatus.ROUND_IS_NOT_POSITIVE_EXCEPTION_STATUS;

import racingcar.exception.RacingCarIllegalArgumentException;

public class RoundNotPositiveException extends RacingCarIllegalArgumentException {

    public RoundNotPositiveException() {
        super(ROUND_IS_NOT_POSITIVE_EXCEPTION_STATUS.getMessage());
    }

}
