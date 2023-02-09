package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

	NumberGenerator numberGenerator;

	public CarService(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void moveCars() {
		List<Car> cars = CarRepository.getCars();
		cars.stream().forEach(car -> car.move(numberGenerator.getNumber()));
	}

	// TODO: change into single stream
	public List<String> getWinners() {
		List<String> winners = new ArrayList<>();
		List<Car> cars = CarRepository.getCars();

		final int[] max = {0};
		// cars.stream().forEach(car -> {
		// 	if (car.getPosition() > max[0]) {
		// 		max[0] = car.getPosition();
		// 		winners.clear();
		// 	}
		// 	winners.add(car.getName());
		// });
		//
		// return winners;
		cars.stream()
			.forEach(car -> max[0] = car.getPosition() > max[0] ? car.getPosition() : max[0]);

		return cars.stream()
			.filter(car -> car.getPosition() == max[0])
			.map(car -> car.getName())
			.collect(Collectors.toList());
	}
}
