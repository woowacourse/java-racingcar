package domain.strategy;

import domain.RandomNumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
	private static final int ADVANCE_MIN_NUMBER = 4;
	private final RandomNumberGenerator randomNumberGenerator;

	public RandomMovingStrategy(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public boolean isMove() {
		return randomNumberGenerator.generate() >= ADVANCE_MIN_NUMBER;
	}
}
