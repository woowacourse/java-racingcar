package racingGame.domain;

import java.util.Objects;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Name(final String name) {
		checkNameEmpty(name.trim());
		checkNameLength(name.trim());
		this.name = name.trim();
	}

	private void checkNameEmpty(String name) {
		if(name.trim().isEmpty()){
			throw new IllegalArgumentException("공백인 이름이 있습니다.");
		}
	}

	private void checkNameLength(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 5자이하만 가능합니다.");
		}
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name = (Name)o;
		return Objects.equals(this.name, name.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
