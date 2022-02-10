package racingcar.exception.car;

import racingcar.exception.RacingCarException;

public class CarNameEmptyException extends RacingCarException {

	public CarNameEmptyException() {
		super("자동차의 이름은 공백이 될 수 없습니다.");
	}

}
