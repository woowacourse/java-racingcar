package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.service.RandomNumberService;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars() {
		cars.stream().forEach(car -> car.move(RandomNumberService.getRandomNumber()));
	}

	public List<String> getPosition() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}

	public List<String> findWinnerCars() {
		Car maxPositionCar = findWinnerCar();
		List<String> winners = new ArrayList<String>();
		cars.stream()
			.filter(maxPositionCar::isSamePosition)
			.forEach(car -> car.appendName(winners));
		return winners;
	}

	public Car findWinnerCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException());
	}
}
