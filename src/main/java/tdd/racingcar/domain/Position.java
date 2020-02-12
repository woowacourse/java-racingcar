package tdd.racingcar.domain;

public class Position {
	private static final int MIN_POSITION = 0;

	private int position;

	public Position(final int position) {
		checkValidationOf(position);
		this.position = position;
	}

	private void checkValidationOf(final int position) {
		if (isInvalid(position)) {
			throw new IllegalArgumentException("자동차의 위치는 0 이상이어야 합니다.");
		}
	}

	private boolean isInvalid(final int position) {
		return position < MIN_POSITION;
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
}
