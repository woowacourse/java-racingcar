package racingcar.domain.car;

public class Position {
	private static final int POSITION_DEFAULT_VALUE = 0;

	private final int value;

	public Position() {
		this.value = POSITION_DEFAULT_VALUE;
	}

	public Position(int value) {
		this.value = value;
	}

	public Position move(Position position) {
		return new Position(this.value + position.value);
	}

	public boolean isSame(Position position) {
		return this.value == position.value;
	}

	public int getValue() {
		return value;
	}
}
