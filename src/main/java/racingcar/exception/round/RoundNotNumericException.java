package racingcar.exception.round;

import static racingcar.exception.round.status.RoundExceptionStatus.ROUND_IS_NOT_NUMERIC_EXCEPTION_STATUS;

import racingcar.exception.RacingCarIllegalArgumentException;

public class RoundNotNumericException extends RacingCarIllegalArgumentException {

    public RoundNotNumericException() {
        super(ROUND_IS_NOT_NUMERIC_EXCEPTION_STATUS.getMessage());
    }

}
