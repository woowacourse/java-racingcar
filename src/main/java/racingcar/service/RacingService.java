package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingService {
	private static final CarRepository carRepository = new CarRepository();

	public void registerCars(List<Car> carList) {
		carList.forEach(carRepository::addCar);
	}
}
