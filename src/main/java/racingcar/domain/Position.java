package racingcar.domain;

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
}
