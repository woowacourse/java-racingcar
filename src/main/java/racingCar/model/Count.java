package racingCar.model;

import racingCar.exception.count.CountRangeException;

public class Count {
	private final int count;

	public Count(int count) {
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
