package racingcar.controller.picker;

public enum RandomRange {

	INCLUSIVE_MINIMUM(0),
	INCLUSIVE_MAXIMUM(9);

	private final int number;

	RandomRange(int number) {
		this.number = number;
	}

	public static int getInclusiveMinimum() {
		return INCLUSIVE_MINIMUM.number;
	}

	public static int getInclusiveMaximum() {
		return INCLUSIVE_MAXIMUM.number;
	}

	public static int getSize() {
		return INCLUSIVE_MAXIMUM.number - INCLUSIVE_MINIMUM.number + 1;
	}

}
