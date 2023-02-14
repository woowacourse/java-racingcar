package racingcar.domain.car;

import static racingcar.messsages.ExceptionMessage.*;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private final String value;

	public CarName(String value) {
		validateNameNullOrBlank(value);
		validateNameLength(value);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private void validateNameNullOrBlank(final String value) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameLength(final String value) {
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
	}
}
