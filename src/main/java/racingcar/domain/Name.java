package racingcar.domain;

import java.util.Objects;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Name.java
 * 이름관련 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        14 Feb 2020
 *
 */
public class Name {
	private static final int MINIMUM_LENGTH_OF_NAME = 1;
	private static final int MAXIMUM_LENGTH_OF_NAME = 5;
	private static final String NULL_OR_BLANK_NAME_EXCEPTION_MESSAGE = "name can not be null or blank";
	private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "name must be between 1-5";

	private final String name;

	public Name(String name) {
		validate(name);
		this.name = name;
	}

	private void validate(String name) {
		validateNullOrBlank(name);
		validateLength(name);
	}

	private void validateNullOrBlank(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException(NULL_OR_BLANK_NAME_EXCEPTION_MESSAGE);
		}
	}

	private void validateLength(String name) {
		if (name.length() < MINIMUM_LENGTH_OF_NAME || name.length() > MAXIMUM_LENGTH_OF_NAME) {
			throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
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
