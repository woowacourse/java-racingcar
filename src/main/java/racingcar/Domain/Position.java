package racingcar.Domain;

import java.util.Objects;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */
public class Position {
	private int position;

	public Position() {
		this.position = 1;
	}

	public Position(Integer inputPosition) {
		Objects.requireNonNull(inputPosition, "자동차 위치는 null일 수 없습니다.");
		validatePosition(inputPosition);
		this.position = inputPosition;
	}

	private void validatePosition(Integer inputPosition) {
		if (inputPosition < 1) {
			throw new IllegalArgumentException("양수만 입력해야합니다.");
		}
	}

	public void moveForward() {
		this.position++;
	}

	public int getPosition() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position) o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
