package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.service.RandomNumberService;

public class Cars {
	private static final String COMMA_DELIMITER = ",";

	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void makeCars(String carNames) {
		this.cars = toCar(splitCarNames(carNames));
	}

	private List<Car> toCar(List<String> carNames) {
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private List<String> splitCarNames(String carNames) {
		return Arrays.asList(carNames.split(COMMA_DELIMITER));
	}

	public void moveCars() {
		cars.forEach(car -> car.move(RandomNumberService.getRandomNumber()));
	}

	public List<String> getPosition() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}

	public List<String> findWinnerCars() {
		Car maxPositionCar = findWinnerCar();
		List<String> winners = new ArrayList<>();
		cars.stream()
			.filter(maxPositionCar::isSamePosition)
			.forEach(car -> car.appendName(winners));
		return winners;
	}

	public Car findWinnerCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(IllegalArgumentException::new);
	}
}
