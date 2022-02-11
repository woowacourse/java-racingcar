package racingcar.exception.round;

import racingcar.exception.RacingCarException;
import racingcar.exception.round.message.RoundExceptionMessage;

public class RoundNotNumericException extends RacingCarException {

	public RoundNotNumericException() {
		super(RoundExceptionMessage.ROUND_NOT_NUMERIC_EXCEPTION_MESSAGE);
	}

}
