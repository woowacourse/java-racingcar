package domain;

public class RandomNo {
	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;
	private static final int MIN_MOVABLE_VALUE = 4;
	private static final String WRONG_RANDOM_VALUE = "잘못된 랜덤 넘버 입니다.";

	private final int number;

	public RandomNo(final int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(final int number) {
		if (number < MIN_RANDOM_VALUE || number > MAX_RANDOM_VALUE) {
			throw new IllegalArgumentException(WRONG_RANDOM_VALUE);
		}
	}

	public boolean isMove() {
		return this.number >= MIN_MOVABLE_VALUE;
	}
}
