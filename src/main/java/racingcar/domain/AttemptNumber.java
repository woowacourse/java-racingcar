package racingcar.domain;

public class AttemptNumber {

	private static final String ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";
	private static final int MINIMUM_ATTEMPT_NUMBER = 1;

	private final int attemptNumber;

	private AttemptNumber(int attemptNumber) {
		validateAttemptNumberRange(attemptNumber);
		this.attemptNumber = attemptNumber;
	}

	public static AttemptNumber from(int attemptNumber) {
		return new AttemptNumber(attemptNumber);
	}

	private void validateAttemptNumberRange(int attemptNumber) {
		if (attemptNumber < MINIMUM_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	public boolean isSameNumber(int attemptNumber) {
		return this.attemptNumber == attemptNumber;
	}
}
