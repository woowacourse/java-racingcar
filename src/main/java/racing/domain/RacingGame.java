package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

import racing.controller.RandomGenerator;

public class RacingGame {
	private List<Car> cars;

	public RacingGame(List<Car> cars) {
		if (cars == null) {
			throw new IllegalArgumentException();
		}

		this.cars = cars;
	}

	public List<Car> findWinner() {
		return cars.stream()
			.filter(car -> car.isSamePosition(findWinnersPosition()))
			.collect(Collectors.toList());
	}

	private int findWinnersPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.reduce(Integer::max)
			.orElse(0);
	}

	public void playRound() {
		cars.forEach(car -> car.goForward(RandomGenerator.randomGenerate()));
	}

	public int carSize() {
		return cars.size();
	}

	public List<String> getAllNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
