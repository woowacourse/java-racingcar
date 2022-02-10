package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.utils.RandomIntegerGenerator;

public class RacingService {
	private final int START_RANDOM_NUMBER = 0;
	private final int END_RANDOM_NUMBER = 9;
	private final List<Car> cars;

	public RacingService(List<Car> cars) {
		this.cars = cars;
	}



	public void race(int round) {
		for (int i = 0; i < round; i++) {
			raceRound();
		}
	}

	private void raceRound() {
		cars.forEach(
			(car) -> car.proceed(RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER))
		);
		// todo 라운드 결과 출력(자동차 위치)
	}

	public List<Car> findWinners() {
		List<Car> winners = new ArrayList<>();

		int maxPosition = cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(IllegalStateException::new);

		cars.forEach((car) -> addWinner(winners, maxPosition, car));
		return winners;
	}

	private void addWinner(List<Car> winners, int maxPosition, Car car) {
		if (car.isWinner(maxPosition)) {
			winners.add(car);
		}
	}
}
