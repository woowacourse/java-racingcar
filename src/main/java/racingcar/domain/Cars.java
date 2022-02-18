package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.domain.strategy.FixedMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;

public class Cars {

	private static final String CAR_NAME_DELIMINATOR = ",";
	private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";
	public static final String INVALID_DUPLICATE_CAR_NAMES = "[ERROR] 차 이름이 중복됩니다";
	private static final String INVALID_EMPTY_CAR_NAMES = "[ERROR] 차 이름은 공백이 될 수 없습니다";

	private MovingStrategy randomMovingStrategy;
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public Cars(final String carNames) {
		this(carNames, new FixedMovingStrategy());
	}

	public Cars(final String carNames, final MovingStrategy randomMovingStrategy) {
		final List<String> parsedCarNames = List.of(splitCarNames(carNames));
		this.randomMovingStrategy = randomMovingStrategy;
		cars  = new ArrayList<>();

		validateCarNamesEmpty(parsedCarNames);
		validateDuplication(parsedCarNames);

		for (final String carName : parsedCarNames) {
			final Car car = Car.builder()
				.name(carName)
				.movingStrategy(randomMovingStrategy)
				.build();

			cars.add(car);
		}
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	private void validateCarNamesEmpty(final List<String> carNames) {
		if (carNames.size() == 0) {
			throw new RuntimeException(INVALID_EMPTY_CAR_NAMES);
		}
	}

	private void validateDuplication(List<String> carNames) {
		if (isDuplicated(carNames)) {
			throw new RuntimeException(INVALID_DUPLICATE_CAR_NAMES);
		}
	}

	private boolean isDuplicated(final List<String> carNames) {
		return carNames.size() != new HashSet<>(carNames).size();
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}

	@Override
	public String toString() {
		return "Cars{" +
			"cars=" + cars +
			'}';
	}
}
