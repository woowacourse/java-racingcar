package racingcar.domain.car;

public class Position {
	public static final Position INIT = new Position(0);

	private final int value;

	public Position(int value) {
		this.value = value;
	}

	public Position move(final Position position) {
		return new Position(this.value + position.value);
	}

	public boolean isSame(final Position position) {
		return this.value == position.value;
	}

	public int getValue() {
		return value;
	}
}
