package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
	private static final String NAME_REGEX = ",";

	public static List<Car> of(String names) {
		return Arrays.stream(splitNames(names))
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private static String[] splitNames(String names) {
		return (String[])Arrays.stream(names.split(NAME_REGEX))
			.map(String::trim)
			.toArray();
	}
}
