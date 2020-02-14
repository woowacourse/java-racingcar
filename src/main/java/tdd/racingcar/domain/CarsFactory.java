package tdd.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import tdd.racingcar.util.InputUtils;

public class CarsFactory {
	private CarsFactory() {}

	public static Cars create(final String input) {
		List<String> names = InputUtils.splitByComma(input);
		return new Cars(
				names.stream()
						.map(Car::new)
						.collect(Collectors.toList())
		);
	}
}
