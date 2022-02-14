package racingcar.domain;

import racingcar.domain.validation.CarsValidator;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
	private static final String MAX_FIND_ERROR = "max 값을 찾을 수 없습니다.";

	private List<Car> cars;

	public Cars(String[] names) {
		CarsValidator validator = new CarsValidator();
		validator.carsValid(names);
		cars = new ArrayList<>();
		for (String name : names) {
			cars.add(createCar(name));
		}
	}

	public void play() {
		for (Car car : cars) {
			car.drive();
		}
		Output.roundResult(cars);
	}
	private Car createCar(String name) {
		return new Car(name.trim());
	}

	public List<String> findWinners() {
		Car maxPositionCar = findMaxPositionCar();
		return findSamePositionCar(maxPositionCar);
	}

	private Car findMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new NoSuchElementException(MAX_FIND_ERROR));
	}

	private List<String> findSamePositionCar(Car target) {
		return cars.stream()
			.filter(car -> car.isSamePosition(target))
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
