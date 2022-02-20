package racingcar.model.movegenerator;

import java.util.Random;

public class NonMovableGenerator implements MoveGenerator {

	private static final int NON_MOVABLE_NUMBER = 4;
	private static final Random random = new Random();

	@Override
	public int generate() {
		return random.nextInt(NON_MOVABLE_NUMBER);
	}
}
