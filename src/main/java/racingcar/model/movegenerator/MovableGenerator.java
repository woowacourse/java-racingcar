package racingcar.model.movegenerator;

import java.util.Random;

public class MovableGenerator implements MoveGenerator {

	private static final int NON_MOVABLE_NUMBER = 4;
	private static final int MAX_MOVABLE_NUMBER = 10;
	private static final Random random = new Random();

	@Override
	public int generate() {
		return random.nextInt(MAX_MOVABLE_NUMBER) + NON_MOVABLE_NUMBER;
	}
}
