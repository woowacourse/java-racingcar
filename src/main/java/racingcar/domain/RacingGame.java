package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.MovingNumberPolicy;

public class RacingGame {

	private static final int RANDOM_VALUE_RANGE = 10;

	private final List<Car> cars;
	private final AttemptNumber attemptNumber;
	private final RacingResult racingResult = new RacingResult();

	private RacingGame(List<Car> cars, AttemptNumber attemptNumber) {
		this.cars = cars;
		this.attemptNumber = attemptNumber;
	}

	public static RacingGame of(List<Car> cars, AttemptNumber attemptNumber) {
		return new RacingGame(cars, attemptNumber);
	}

	public List<Car> start(MovingNumberPolicy movingNumberPolicy) {
		for (int i = 0; i < attemptNumber.value(); i++) {
			playRound(movingNumberPolicy);
			racingResult.add(cars.stream()
				.map(Car::copy)
				.collect(Collectors.toList()));
		}

		return cars;
	}

	private void playRound(MovingNumberPolicy movingNumberPolicy) {
		cars.forEach(car -> car.move(movingNumberPolicy.generate(RANDOM_VALUE_RANGE)));
	}

	public List<Car> findResultCars(Round round) {
		return racingResult.findResult(round);
	}
}
