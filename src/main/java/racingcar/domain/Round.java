package racingcar.domain;

import racingcar.constants.Constants;
import racingcar.exception.InvalidRoundException;
import racingcar.exception.NotDigitRoundException;

public class Round {

	private int count;

	public Round(String count) {
		int value = parseCount(count);
		validateCountPositive(value);
		this.count = value;
	}

	private int parseCount(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException exception) {
			throw new NotDigitRoundException();
		}
	}

	private void validateCountPositive(int count) {
		if (count < Constants.MINIMUM_ROUND) {
			throw new InvalidRoundException();
		}
	}

	public void decreaseCount() {
		this.count--;
	}

	public boolean isFinish() {
		return this.count == Constants.FINISH_ROUND;
	}

	public int getCount() {
		return count;
	}
}
