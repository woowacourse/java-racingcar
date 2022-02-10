package racingcar.exception.car;

import racingcar.exception.RacingCarException;

public class CarNameTooLongException extends RacingCarException {

	public CarNameTooLongException() {
		super("자동차의 이름은 5자 이하여야 합니다.");
	}

}
