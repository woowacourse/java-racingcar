package racingcar.domain.car;

import racingcar.domain.movement.v1.Movement;
import racingcar.domain.movement.v2.MovementForwardStrategy;
import racingcar.domain.movement.v2.MovementStopStrategy;
import racingcar.domain.movement.v2.MovementStrategy;
import racingcar.domain.number.NumberGenerator;

public class CarMovement {
	private final NumberGenerator numberGenerator;
	private MovementStrategy movementStrategy;

	public CarMovement(final NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	// enum 활용
	public Movement moveV1() {
		return Movement.from(numberGenerator.generateNumber());
	}

	// 전략 패턴 활용
	public int moveV2() {
		int number = numberGenerator.generateNumber();
		if (0 <= number && number <= 3) {
			movementStrategy = new MovementStopStrategy();
		}
		if (4 <= number && number <= 9) {
			movementStrategy = new MovementForwardStrategy();
		}
		return movementStrategy.getDistance();
	}
}
