package racingcar.domain.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMovingStrategy implements MovingStrategy {

	private static final ThreadLocalRandom random = ThreadLocalRandom.current();
	private static final int RANDOM_MAX_BOUND = 9 + 1;
	private static final int RANDOM_PIVOT = 4;

	@Override
	public boolean movable() {
		return isMove();
	}

	private boolean isMove() {
		return random.nextInt(RANDOM_MAX_BOUND) < RANDOM_PIVOT;
	}
}
