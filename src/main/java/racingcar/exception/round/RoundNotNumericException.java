package racingcar.exception.round;

import racingcar.exception.RacingCarException;

public class RoundNotNumericException extends RacingCarException {

	public RoundNotNumericException() {
		super("이동 횟수는 숫자여야 합니다.");
	}

}
