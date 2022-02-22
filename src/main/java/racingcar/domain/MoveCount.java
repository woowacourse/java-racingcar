package racingcar.domain;

public class MoveCount {
	public static final String ERROR_NOT_POSITIVE = "[ERROR] 이동횟수는 1 이상의 정수여야 합니다.";

	private final int moveCount;

	public MoveCount(int moveCount) {
		validateMoveCount(moveCount);
		this.moveCount = moveCount;
	}

	private static void validateMoveCount(int moveCount) {
		checkPositiveInteger(moveCount);
	}

	private static void checkPositiveInteger(int moveCount) {
		if (moveCount <= 0) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
		}
	}

	public int toInt() {
		return moveCount;
	}
}
