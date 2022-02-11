package racingcar.domain.round;

public enum RoundRange {

	MINIMUM(0);

	private final int number;

	RoundRange(int number) {
		this.number = number;
	}

	public static int getMinimum() {
		return MINIMUM.number;
	}

	public static boolean isTooSmall(int count) {
		return (count < getMinimum());
	}

}