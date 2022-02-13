package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.strategy.MovingStrategy;

public class Cars {

	private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";
	private static final String CAR_NAME_DELIMINATOR = ",";

	private List<Car> cars = new ArrayList<>();

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Cars(String carNames) {
		String[] parseCarNames = parseCarNames(carNames);

		for (String carName : parseCarNames) {
			Car car = Car.createRandomMovingCar(carName);
			cars.add(car);
		}
	}

	public List<Car> get() {
		return cars;
	}

	private String[] parseCarNames(String input) {
		input = input.replaceAll(" ", "");
		return input.split(CAR_NAME_DELIMINATOR);
	}

	public List<Car> getWinners() {

		Car maxCar = getMaxPositionCar();

		return cars.stream()
			.filter(car -> car.isSamePosition(maxCar))
			.collect(Collectors.toList());
	}

	private Car getMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.stream()
			.findAny()
			.orElseThrow(() -> new RuntimeException(NOT_FOUND_CARS_MESSAGE));
	}
}
