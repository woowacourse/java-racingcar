package tdd.racingcar.domain;

public class Position {
	private static final int MIN_POSITION = 0;

	private int position;

	public Position(final int position) {
		validate(position);
		this.position = position;
	}

	private void validate(final int position) {
		if (position < MIN_POSITION) {
			throw new IllegalArgumentException("자동차의 위치는 0 이상이어야 합니다.");
		}
	}

	public void move() {
		position++;
	}

	public int getPosition() {
		return position;
	}

	public boolean isPosition(final int position) {
		return this.position == position;
	}

	public boolean isPosition(final Position other) {
		return this.position == other.position;
	}
}
