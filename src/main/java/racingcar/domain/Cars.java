package racingcar.domain;

import static racingcar.validator.CarNameValidator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import racingcar.domain.strategy.FixedMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;

public class Cars {

	private static final String CAR_NAME_DELIMINATOR = ",";
	private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";

	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public Cars(final String carNames) {
		this(carNames, new FixedMovingStrategy());
	}

	public Cars(final String carNames, final MovingStrategy randomMovingStrategy) {
		final List<String> parsedCarNames = List.of(splitCarNames(carNames));
		cars  = new ArrayList<>();

		validateCarNames(parsedCarNames);

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

	private String[] splitCarNames(String input) {
		return input.replaceAll("\\s", "").split(CAR_NAME_DELIMINATOR);
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
