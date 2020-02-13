package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

import racing.controller.RandomGenerator;

public class RacingGame {
	private List<Car> cars;

	public RacingGame(List<String> carNames) {
		cars = carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
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

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.joining("\n"));
	}

	// 테스트코드에서만 사용하는 getter 메소드
	public List<Car> getCars() {
		return this.cars;
	}
}
