package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

	private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";
	private static final String CAR_NAME_DELIMINATOR = ",";

	private List<Car> cars = new ArrayList<>();

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Cars(String carNames) {
		String[] parseCarNames = splitCarNames(carNames);

		for (String carName : parseCarNames) {
			Car car = Car.createRandomMovingCar(carName);
			cars.add(car);
		}
		validateCarNames(cars);
	}

	private void validateCarNames(List<Car> cars) {
		if (isValidated(cars)) {
			throw new RuntimeException("차 이름이 중복됩니다");
		}
	}

	private boolean isValidated(List<Car> cars) {
		return cars.size() != new HashSet<>(cars).size();
	}

	public List<Car> get() {
		return cars;
	}

	private String[] splitCarNames(String input) {
		input = input.replaceAll("\\s", "");
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
			.max(Car::comparePositionTo)
			.stream()
			.findAny()
			.orElseThrow(() -> new RuntimeException(NOT_FOUND_CARS_MESSAGE));
	}
}
