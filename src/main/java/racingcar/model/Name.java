package racingcar.model;

import racingcar.message.ErrorMessages;

public class Name {
	private static final int MAX_LENGTH = 5;

	private final String name;

	public Name(String name) {
		this.name = name;
		validate();
	}

	@Override
	public String toString() {
		return this.name;
	}

	private void validate() {
		validateNotEmpty();
		validateBoundary();
	}

	private void validateNotEmpty() {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.EMPTY_NAME);
		}
	}

	private void validateBoundary() {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(ErrorMessages.LONG_NAME);
		}
	}
}