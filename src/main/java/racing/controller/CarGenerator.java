package racing.controller;

import java.util.List;
import java.util.stream.Collectors;

import racing.domain.Car;

public class CarGenerator {
	public List<Car> generateCars(List<String> carNames) {
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
