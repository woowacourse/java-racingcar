package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.RandomIntegerGenerator;

public class RacingService {
	private static final int START_RANDOM_NUMBER = 0;
	private static final int END_RANDOM_NUMBER = 9;
	private final List<Car> cars;

	public RacingService(List<Car> cars) {
		this.cars = cars;
	}

	public void race(int round) {
		for (int i = 0; i < round; i++) {
			raceRound();
		}
	}

	public List<Car> findWinners() {
		List<Car> winners = new ArrayList<>();
		int maxPosition = findMaxPosition();
		cars.forEach((car) -> addWinner(winners, maxPosition, car));
		return winners;
	}

	private int findMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(IllegalStateException::new);
	}

	private void raceRound() {
		cars.forEach(
			(car) -> car.proceed(RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER))
		);
		RacingCarOutput.printRoundResult(cars);
		System.out.println();
	}

	private void addWinner(List<Car> winners, int maxPosition, Car car) {
		if (car.isWinner(maxPosition)) {
			winners.add(car);
		}
	}
}
