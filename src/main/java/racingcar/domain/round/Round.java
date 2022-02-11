package racingcar.domain.round;

import racingcar.exception.round.RoundNotPositiveException;

public class Round {

	private int count;

	public Round(int count) {
		validateCountPositive(count);
		this.count = count;
	}

	private void validateCountPositive(int count) {
		if (RoundRange.isTooSmall(count)) {
			throw new RoundNotPositiveException();
		}
	}

	public boolean isNotFinished() {
		return (this.count != 0);
	}

	public void decreaseCount() {
		this.count--;
	}

}
