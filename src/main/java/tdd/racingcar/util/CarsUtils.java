package tdd.racingcar.util;

import static java.util.stream.Collectors.*;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Cars;

public class CarsUtils {
	private static final String COLON = " : ";
	private static final String POSITION_MARK = "-";
	private static final String DELIMITER = ", ";
	private static final String NEW_LINE = "\n";

	public static String getState(final Cars cars) {
		return cars.toList().stream()
			.map(CarsUtils::makeState)
			.collect(joining(NEW_LINE));
	}

	private static String makeState(final Car car) {
		return car.getName() + COLON + POSITION_MARK.repeat(car.getPosition());
	}

	public static String getWinners(final Cars cars) {
		final int maxPosition = cars.getMaxPosition();
		return cars.toList().stream()
			.filter(car -> car.isPosition(maxPosition))
			.map(Car::getName)
			.collect(joining(DELIMITER));
	}
}
