package racingcar.exception.round;

import racingcar.exception.RacingCarException;

public class RoundNotPositiveException extends RacingCarException {

	public RoundNotPositiveException() {
		super("이동 횟수는 양수여야 합니다.");
	}

}
