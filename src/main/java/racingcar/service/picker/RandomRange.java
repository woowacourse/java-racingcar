package racingcar.service.picker;

public enum RandomRange {

	INCLUSIVE_MINIMUM(0),
	EXCLUSIVE_MAXIMUM(10);

	private final int number;

	RandomRange(int number) {
		this.number = number;
	}

	public static int getInclusiveMinimum() {
		return INCLUSIVE_MINIMUM.number;
	}

	public static int getSize() {
		return EXCLUSIVE_MAXIMUM.number - INCLUSIVE_MINIMUM.number;
	}

}
