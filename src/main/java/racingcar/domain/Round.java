package racingcar.domain;

import racingcar.exception.InvalidRoundException;
import racingcar.exception.NotDigitRoundException;

public class Round {

	private static final int FINISH_ROUND = 0;
	private static final int MINIMUM_ROUND = 1;
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
		if (count < MINIMUM_ROUND) {
			throw new InvalidRoundException();
		}
	}

	public void decreaseCount() {
		this.count--;
	}

	public boolean isFinish() {
		return this.count == FINISH_ROUND;
	}

	public int getCount() {
		return count;
	}
}
