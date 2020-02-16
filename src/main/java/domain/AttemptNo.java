package domain;

public class AttemptNo {
	private static final String NOT_INTEGER_MESSAGE = "정수가 아닙니다.";
	private static final String NOT_POSITIVE_MESSAGE = "양수가 아닙니다.";
	private static final int MIN_ATTEMPT_NUMBER = 1;

	private int number;

	public AttemptNo(final String number) {
		validateInteger(number);
		validatePositive(number);
		this.number = Integer.parseInt(number);
	}

	private void validateInteger(final String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
		}
	}

	private void validatePositive(final String number) {
		if (Integer.parseInt(number) < MIN_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
		}
	}

	public boolean execute() {
		if (!isEnd()) {
			this.number--;
			return true;
		}
		return false;
	}

	public boolean isEnd() {
		return this.number < MIN_ATTEMPT_NUMBER;
	}
}
