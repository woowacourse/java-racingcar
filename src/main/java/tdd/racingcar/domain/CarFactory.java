package tdd.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
	public static List<Car> create(List<String> names) {
		return names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
