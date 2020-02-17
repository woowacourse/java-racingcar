package racingcargame.domain;

import java.util.Random;

public class NumberGenerator implements MoveStrategy {
	private static final int RANDOM_BOUND = 10;
	private static final int MOVE_BOUND = 6;
	private static final int STOP_BOUND = 4;
	private static final Random random = new Random();

	@Override
	public int getRandomNo() {
		return random.nextInt(RANDOM_BOUND);
	}

	@Override
	public int getMoveNo() {
		return random.nextInt(MOVE_BOUND) + STOP_BOUND;
	}

	@Override
	public int getStopNo() {
		return random.nextInt(STOP_BOUND);
	}
}
