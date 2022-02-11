package racingcar.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

	private static final Random random = new Random();
	private static final int RANDOM_MAX_BOUND = 10;
	private static final int RANDOM_PIVOT = 4;

	private boolean isMove() {
		return random.nextInt(RANDOM_MAX_BOUND) < RANDOM_PIVOT;
	}

	@Override
	public boolean movable() {
		return isMove();
	}
}
