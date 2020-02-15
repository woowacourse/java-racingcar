package tdd.racingcar.util;

import static java.util.stream.Collectors.*;

import tdd.racingcar.domain.Car;
import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.Name;
import tdd.racingcar.domain.Position;

public class OutputUtils {
	private static final String COLON = " : ";
	private static final String POSITION_MARK = "-";
	private static final String DELIMITER = ", ";
	private static final String NEW_LINE = "\n";
	private static final int NEW_LINE_COUNT = 2;

	public static String getState(Cars cars) {
		return cars.stream()
			.map(OutputUtils::makeState)
			.collect(joining(NEW_LINE)) + NEW_LINE.repeat(NEW_LINE_COUNT);
	}

	private static String makeState(Car car) {
		final Position position = car.getPosition();
		final String distance = position.toString();
		return car.getName() + COLON + POSITION_MARK.repeat(Integer.parseInt(distance));
	}

	public static String getWinnerState(Cars cars) {
		return cars.getWinnerNames().stream()
			.map(Name::toString)
			.collect(joining(DELIMITER));
	}
}
