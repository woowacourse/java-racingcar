package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.RandomNumberCreator;

public class Racing {
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	private List<Car> cars;
	private int numberOfTimes;
	private RacingResult racingResult;

	public Racing(List<String> carNames, int numberOfTimes) {
		this.cars = carNames.stream()
				.map(Car::new)
				.collect(Collectors.toList())
		;
		this.numberOfTimes = numberOfTimes;
		this.racingResult = new RacingResult();
	}

	public Winner run() {
		for (int i = 0; i < numberOfTimes; ++i) {
			cars.forEach(car -> car.moveOrNot(RandomNumberCreator.create(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)));
			cars.forEach(car -> racingResult.saveCarPosition(cars));
		}

		return getWinner();
	}

	private Car getMaxPositionCar() {
		Collections.sort(cars);
		return cars.get(cars.size() - 1);
	}

	public RacingResult getRacingResult() {
		return racingResult;
	}

	public Winner getWinner() {
		return new Winner(cars, getMaxPositionCar());
	}
}

