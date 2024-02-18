package domain.strategy;

import constants.ErrorMessages;
import utils.Randoms;

public class RandomNumberMovingStrategy implements MovingStrategy {

	private static final int MIN_NUMBER_FOR_MOVE = 4;
	private static final int MIN_RANDOM_NUMBER_RANGE = 0;
	private static final int MAX_RANDOM_NUMBER_RANGE = 9;

	@Override
	public boolean canMove() {
		int randomNumber = Randoms.getRandomNumber(MAX_RANDOM_NUMBER_RANGE);
		return isGraterThanMovingNumber(randomNumber);
	}

	private boolean isGraterThanMovingNumber(int number) {
		validateNumberRange(number);
		return number >= MIN_NUMBER_FOR_MOVE;
	}

	private void validateNumberRange(int number) {
		if (number < MIN_RANDOM_NUMBER_RANGE || number > MAX_RANDOM_NUMBER_RANGE) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_RANDOM_NUMBER.getMessage());
		}
	}
}
