package racingcar.domain.round.condition;

public enum RoundRange {

	MINIMUM(1);

	private final int number;

	RoundRange(int number) {
		this.number = number;
	}

	public static boolean isTooSmall(int count) {
		return (count < MINIMUM.number);
	}

}