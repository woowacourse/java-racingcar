package racingcar.exception.car;

import racingcar.exception.RacingCarException;

public class CarNameDuplicatedException extends RacingCarException {

	public CarNameDuplicatedException() {
		super("자동차의 이름은 중복될 수 없습니다.");
	}

}
