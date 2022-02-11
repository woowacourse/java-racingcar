package racingcar.model;

import java.util.Objects;

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
		validateLength();
	}

	private void validateNotEmpty() {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.EMPTY_NAME);
		}
	}

	private void validateLength() {
		if (name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(ErrorMessages.LONG_NAME);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}