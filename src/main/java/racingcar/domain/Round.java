package racingcar.domain;

import racingcar.exception.round.RoundNotPositiveException;

public class Round {

	private int count;

	public Round(int count) {
		validateCountPositive(count);
		this.count = count;
	}

	private void validateCountPositive(int count) {
		if (count <= 0) {
			throw new RoundNotPositiveException();
		}
	}

	public void decreaseCount() {
		this.count--;
	}

	public boolean isFinish() {
		return this.count == 0;
	}

	public int getCount() {
		return count;
	}
}
