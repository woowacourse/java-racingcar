package racingcar.domain;

import java.util.List;

import racingcar.util.RandomUtil;

public class RacingGame {

	private static final int RANDOM_VALUE_RANGE = 10;

	private List<Car> cars;
	private int round;

	private RacingGame(List<Car> cars, int round) {
		this.cars = cars;
		this.round = round;
	}

	public static RacingGame of(List<Car> cars, int round) {
		return new RacingGame(cars, round);
	}

	public List<Car> start(RandomUtil randomUtil) {
		for (int i = 0; i < round; i++) {
			playRound(randomUtil);
		}

		return cars;
	}

	private void playRound(RandomUtil randomUtil) {
		cars.forEach(car -> {
			car.move(randomUtil.generate(RANDOM_VALUE_RANGE));
		});
	}
}
