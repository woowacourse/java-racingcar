package racingcar.domain;

import java.util.Objects;

import racingcar.exception.EmptyCarNameException;
import racingcar.exception.OutOfCarNameLengthException;

public class Name {

	private static final int MAX_NAME_LENGTH = 5;
	private final String name;

	public Name(String name) {
		name = removeEmptySpace(name);
		validateName(name);
		this.name = name;
	}

	private String removeEmptySpace(String name) {
		return name.trim();
	}

	private void validateName(String name) {
		validateNameIsTooLong(name);
		validateNameIsEmpty(name);
	}

	private void validateNameIsTooLong(String name) {
		if (name.length() > MAX_NAME_LENGTH)
			throw new OutOfCarNameLengthException();
	}

	private void validateNameIsEmpty(String name) {
		if (name.isEmpty()) {
			throw new EmptyCarNameException();
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
