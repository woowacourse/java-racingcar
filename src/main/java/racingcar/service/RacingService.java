package racingcar.service;

import java.util.Arrays;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {
	private static CarRepository carRepository = new CarRepository();

	public void registerCars(String input) {
		Arrays.stream(input.split(","))
			.forEach(carName -> carRepository.addCar(Car.of(carName)));
	}
}
