package racingcar.util;

public enum IntegerConst {
	RANDOM_UPPER_BOUND(10),
	MOVE_BOUND(3);
	private final int value;

	IntegerConst(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
