package racingCar.model;

import racingCar.exception.count.CountRangeException;

public class RoundCount {
	private final int count;

	public RoundCount(int count) {
		validate(count);
		this.count = count;
	}

	private static void validate(int count) {
		if (count <= 0) {
			throw new CountRangeException();
		}
	}

	public int get() {
		return count;
	}
}
