package racingcar.controller;

import java.util.Arrays;
import java.util.stream.Stream;

import racingcar.model.Car;
import racingcar.model.CarRepository;

public class CarController {
	private CarRepository carRepository = CarRepository.getInstance();

	public void createCars(String userInputCarNames) {
		String[] carNames = splitCarNames(userInputCarNames);
		Arrays.stream(carNames)
			.forEach(carName -> carRepository.save(new Car(carName)));
	}

	public String[] splitCarNames(String input) {
		return Stream.of(input.split(",")).map(String::trim).toArray(String[]::new);
	}

	public void run() {
		carRepository.move();
	}
}
