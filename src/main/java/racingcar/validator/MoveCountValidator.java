package racingcar.validator;

public class MoveCountValidator {
	public static final String ERROR_NOT_POSITIVE = "[ERROR] 이동횟수는 1 이상의 정수여야 합니다.";

	public static void validateMoveCount(int moveCount) {
		checkPositiveInteger(moveCount);
	}

	private static void checkPositiveInteger(int moveCount) {
		if (moveCount <= 0) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
		}
	}
}
