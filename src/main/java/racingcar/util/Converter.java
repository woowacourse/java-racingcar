package racingcar.util;

import racingcar.domain.CarDto;
import racingcar.validator.InputValidator;

public class Converter {

	private static final String SEPARATOR_OF_CAR_NAME = ",";

	public static CarDto toCarDto(String name) {
		return new CarDto(name, 0);
	}

	public static int toAttemptNumber(String input) {
		InputValidator.ofAttemptNumber(input);
		return Integer.parseInt(input);
	}
}
