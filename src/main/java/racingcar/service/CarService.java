package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

	NumberGenerator numberGenerator;

	public CarService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void moveCars() {
		List<Car> cars = CarRepository.getCars();
		for (Car car : cars) {
			car.move(numberGenerator.getNumber());
		}
	}
}
