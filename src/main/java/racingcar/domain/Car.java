package racingcar.domain;

import static racingcar.exception.ErrorMessages.*;

import java.util.Objects;

import racingcar.exception.ErrorMessages;

public class Car {
	final String name;
	int position;

	public Car(String name) {
		validateNameBlank(name);
		validateNameLength(name);
		this.name = name;
		position = 0;
	}

	private void validateNameBlank(String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameLength(String name) {
		int nameLength = name.length();
		if (nameLength > 5) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
	}
}
