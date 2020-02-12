package tdd.racingcar.domain;

import java.util.Objects;

public class Position {
	private int position;

	public Position(final int position) {
		checkValidationOf(position);
		this.position = position;
	}

	private void checkValidationOf(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("자동차의 위치는 0 이상이어야 합니다.");
		}
	}

	public void move() {
		position++;
	}

	public int getPosition() {
		return position;
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
