package racingcar.util;

public enum IntegerConst {
	RANDOM_UPPER_BOUND(10),
	MOVE_BOUND(3),
	SIZE_BOUND(5),
	ZERO(0);
	private final int value;

	IntegerConst(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
