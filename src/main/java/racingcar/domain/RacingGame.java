package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.utils.RandomGenerator;

public class RacingGame {
	private static final int INDEX_INIT = 0;
	private static final String GAGE = "-";
	private static final String EMPTY = "";
	private static final String COLON = " : ";
	private static final String ENTER = "\n";

	public static String showEachRaceResult(Cars cars, int count) {
		StringBuilder result = new StringBuilder();

		for (int i = INDEX_INIT; i < count; i++) {
			race(cars);
			result.append(getRaceResult(cars.getCars()));
		}
		return result.toString();
	}

	private static String getRaceResult(List<Car> cars) {
		StringBuilder raceResult = new StringBuilder();
		for (Car car : cars) {
			String carName = car.getName();

			String resultOfMovement = Stream.generate(() -> GAGE)
				.limit(car.getPosition())
				.collect(Collectors.joining(EMPTY));

			raceResult.append(String.join(COLON, carName, resultOfMovement))
				.append(ENTER);
		}
		raceResult.append(ENTER);
		return raceResult.toString();
	}

	private static void race(Cars cars) {
		for (Car car : cars.getCars()) {
			int randomValue = RandomGenerator.getRandomNumber();
			car.movePositionAccordingToCondition(randomValue);
		}
	}
}
