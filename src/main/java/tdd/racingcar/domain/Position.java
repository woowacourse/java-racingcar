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
		if (position < MIN_POSITION) {
			throw new IllegalArgumentException("자동차의 위치는 0 이상이어야 합니다.");
		}
	}

	public void move() {
		position++;
	}

	public Position getGreater(Position another) {
		if (this.position > another.position) {
			return this;
		}
		return another;
	}

	@Override
	public String toString() {
		return String.valueOf(position);
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
