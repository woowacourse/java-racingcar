package racingcar.controller;

import java.util.List;
import java.util.stream.Stream;

import racingcar.model.CarDto;
import racingcar.model.Cars;
import racingcar.model.Random;

class CarController {
	private static final String CAR_NAME_DELIMITER = ",";

	private final Cars cars;
	private final Random random;

	CarController() {
		this.cars = new Cars();
		this.random = new Random();
	}

	String[] splitCarNames(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER))
			.map(String::trim)
			.toArray(String[]::new);
	}

	void createCars(String carNames) {
		String[] splitCarNames = splitCarNames(carNames);
		cars.createCars(splitCarNames);
	}

	void run() {
		int numberOfCars = cars.getSize();
		cars.moveAll(random.createNumbers(numberOfCars));
	}

	List<CarDto> getCars() {
		return cars.getCars();
	}

	List<CarDto> getWinners() {
		return cars.getWinners();
	}
}
