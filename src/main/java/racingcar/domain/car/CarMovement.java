package racingcar.domain.car;

import racingcar.domain.number.NumberGenerator;

public class CarMovement {
	private final NumberGenerator numberGenerator;

	public CarMovement(final NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public Movement move() {
		return Movement.from(numberGenerator.generateNumber());
	}
}
