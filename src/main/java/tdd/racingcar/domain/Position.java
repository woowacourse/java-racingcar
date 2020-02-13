package tdd.racingcar.domain;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
