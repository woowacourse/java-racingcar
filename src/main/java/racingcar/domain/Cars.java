package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.strategy.RandomMovingStrategy;

public class Cars {

	private static final String CAR_NAME_DELIMINATOR = ",";
	private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";
	public static final String INVALID_DUPLICATE_CAR_NAMES = "[ERROR] 차 이름이 중복됩니다";
	private static final String INVALID_EMPTY_CAR_NAMES = "[ERROR] 차 이름은 공백이 될 수 없습니다";

	private List<Car> cars = new ArrayList<>();

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public Cars(final String carNames) {
		final String[] parseCarNames = splitCarNames(carNames);

		for (final String carName : parseCarNames) {
			final Car car = Car.builder()
				.name(carName)
				.movingStrategy(new RandomMovingStrategy())
				.build();

			cars.add(car);
		}
		validateCarNamesEmpty(parseCarNames);
		validateDuplication(cars);
	}

	public List<Car> getCars() {
		return cars;
	}

	private void validateCarNamesEmpty(final String[] carNames) {
		if (carNames.length == 0) {
			throw new RuntimeException(INVALID_EMPTY_CAR_NAMES);
		}
	}

	private void validateDuplication(List<Car> cars) {
		if (isDuplicated(cars)) {
			throw new RuntimeException(INVALID_DUPLICATE_CAR_NAMES);
		}
	}

	private boolean isDuplicated(final List<Car> cars) {
		return cars.size() != new HashSet<>(cars).size();
	}

	private String[] splitCarNames(String input) {
		input = input.replaceAll("\\s", "");
		return input.split(CAR_NAME_DELIMINATOR);
	}

	public List<Car> getWinners() {

		final Car maxCar = getMaxPositionCar();

		return cars.stream()
			.filter(car -> car.isSamePosition(maxCar))
			.collect(Collectors.toList());
	}

	private Car getMaxPositionCar() {
		return cars.stream()
			.max(Car::comparePositionTo)
			.orElseThrow(() -> new RuntimeException(NOT_FOUND_CARS_MESSAGE));
	}
}
