package racingcargame.domain;

import java.util.Random;

public class MoveDecider implements MoveStrategy {
	private static final int GO_CONDITION = 4;
	private static final int RANDOM_BOUND = 10;
	private static final int MOVE_BOUND = 6;
	private static final int STOP_BOUND = 4;

	private static final Random random = new Random();

	@Override
	public boolean isMovable() {
		return random.nextInt(RANDOM_BOUND) >= GO_CONDITION;
	}

	@Override
	public int getMoveNumber() {
		return random.nextInt(MOVE_BOUND) + STOP_BOUND;
	}

	@Override
	public int getStopNumber() {
		return random.nextInt(STOP_BOUND);
	}
}
