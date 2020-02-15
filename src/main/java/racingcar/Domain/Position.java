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
	private static final String POSITION_CAN_NOT_BE_NULL_EXCEPTION_MESSAGE = "자동차 위치는 null일 수 없습니다.";
	private static final String POSITION_CAN_BE_ONLY_POSITIVE_EXCEPTION_MESSAGE = "양수만 입력해야합니다.";
	private static final int DEFAULT_POSITION = 1;
	private static final int POSITION_LOWER_BOUNDARY = 1;

	private int position;

	public Position() {
		this.position = DEFAULT_POSITION;
	}

	public Position(final Integer inputPosition) {
		Objects.requireNonNull(inputPosition, POSITION_CAN_NOT_BE_NULL_EXCEPTION_MESSAGE);
		validatePosition(inputPosition);
		this.position = inputPosition;
	}

	private void validatePosition(final Integer inputPosition) {
		if (inputPosition < POSITION_LOWER_BOUNDARY) {
			throw new IllegalArgumentException(POSITION_CAN_BE_ONLY_POSITIVE_EXCEPTION_MESSAGE);
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
