package racingcar.exception.round;

import racingcar.exception.RacingCarException;
import racingcar.exception.round.message.RoundExceptionMessage;

public class RoundNotPositiveException extends RacingCarException {

	public RoundNotPositiveException() {
		super(RoundExceptionMessage.ROUND_NOT_POSITIVE_EXCEPTION_MESSAGE);
	}

}
