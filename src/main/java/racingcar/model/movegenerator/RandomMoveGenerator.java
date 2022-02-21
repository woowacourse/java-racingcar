package racingcar.model.movegenerator;

import java.util.Random;

public class RandomMoveGenerator implements MoveGenerator {

	private static final int MAX_RANDOM_NUMBER = 10;
	private static final int MOVE_CRITERIA = 4;
	private static final Random random = new Random();

	@Override
	public boolean isMovable() {
		return random.nextInt(MAX_RANDOM_NUMBER) > MOVE_CRITERIA;
	}
}
