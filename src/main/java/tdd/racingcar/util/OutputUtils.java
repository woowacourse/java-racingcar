package tdd.racingcar.util;

import static java.util.stream.Collectors.*;

import java.util.function.Predicate;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Cars;

public class OutputUtils {
	private static final String COLON = " : ";
	private static final String POSITION_MARK = "-";
	private static final String DELIMITER = ", ";
	private static final String NEW_LINE = "\n";
	private static final int NEW_LINE_COUNT = 2;

	public static String getState(final Cars cars) {
		return cars.stream()
			.map(OutputUtils::makeState)
			.collect(joining(NEW_LINE)) + NEW_LINE.repeat(NEW_LINE_COUNT);
	}

	private static String makeState(final Car car) {
		return car.getName() + COLON + POSITION_MARK.repeat(car.getPosition());
	}

	public static String getWinners(final Cars cars) {
		final int maxPosition = cars.getMaxPosition();
		return cars.stream()
			.filter(isPosition(maxPosition))
			.map(Car::getName)
			.collect(joining(DELIMITER));
	}

	private static Predicate<Car> isPosition(final int position) {
		return car -> car.isPosition(position);
	}
}
