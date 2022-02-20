package racingcar.model;

import java.util.Random;

public interface CarMoveStrategy {

	int CRITERIA = 4;
	int BOUND_RANDOM = 10;

	default Boolean satisfy() {
		return generateRandNum() >= CRITERIA;
	}

	private int generateRandNum() {
		Random random = new Random();

		return random.nextInt(BOUND_RANDOM);
	}

}

