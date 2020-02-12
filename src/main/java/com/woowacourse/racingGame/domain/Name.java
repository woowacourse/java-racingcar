package com.woowacourse.racingGame.domain;

import java.util.Objects;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Name(final String name) {
		checkNameLength(name);
		this.name = name;
	}

	private void checkNameLength(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 5자이하만 가능합니다.");
		}
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
