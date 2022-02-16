package racingcar.domain;

import java.util.List;

import racingcar.util.RandomUtil;

public class RacingGame {

	private static final int RANDOM_VALUE_RANGE = 10;

	private final List<Car> cars;
	private final Attempt attempt;
	private final RacingResult racingResult = new RacingResult();

	private RacingGame(List<Car> cars, Attempt attempt) {
		this.cars = cars;
		this.attempt = attempt;
	}

	public static RacingGame of(List<Car> cars, Attempt attempt) {
		return new RacingGame(cars, attempt);
	}

	public List<Car> start(RandomUtil randomUtil) {
		for (int i = 0; i < attempt.getNumber(); i++) {
			playRound(randomUtil);
			racingResult.add(cars);
		}

		return cars;
	}

	private void playRound(RandomUtil randomUtil) {
		cars.forEach(car -> car.move(randomUtil.generate(RANDOM_VALUE_RANGE)));
	}

	public List<Car> findResultCars(Round round) {
		return racingResult.findResult(round);
	}
}
