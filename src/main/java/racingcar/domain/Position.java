package racingcar.domain;

import java.util.Objects;

public class Position {
	public static final String ERROR_NEGATIVE = "[ERROR] 위치는 0 이상의 정수여야 합니다.";

	private int position;

	public Position(int position) {
		validatePosition(position);
		this.position = position;
	}

	private void validatePosition(int position) {
		checkNegativeInteger(position);
	}

	private static void checkNegativeInteger(int position) {
		if (position < 0) {
			throw new IllegalArgumentException(ERROR_NEGATIVE);
		}
	}

	public void increase() {
		position++;
	}

	public int toInt() {
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
