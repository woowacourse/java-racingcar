package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.validator.Validator;

public class Converter {

	private static final String SEPARATOR_OF_CAR_NAME = ",";

	public static List<Car> toCarList(String input) {
		return Arrays.stream(input.split(SEPARATOR_OF_CAR_NAME))
			.map(Car::from)
			.collect(Collectors.toList());
	}

	public static int toInteger(String input) {
		Validator.ofIntegerInput(input);
		return Integer.parseInt(input);
	}
}
