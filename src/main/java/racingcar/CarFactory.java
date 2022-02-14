package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
	private static final String NAME_REGEX = ",";

	public static List<Car> of(String names) {
		return Arrays.stream(names.split(NAME_REGEX))
			.map(name -> new Car(name.trim()))
			.collect(Collectors.toList());
	}
}
