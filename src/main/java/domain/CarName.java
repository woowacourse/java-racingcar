package domain;

import java.lang.reflect.Array;
import java.util.Arrays;

import constants.ErrorMessages;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public CarName(String name) {
		validate(name);
		this.name = name;
	}

	private void validate(String name) {
		if (isInvalidNameLength(name)) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME.getMessage());
		}
	}

	private static boolean isInvalidNameLength(String name) {
		return name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH;
	}

	public String getName() {
		return name;
	}
}
