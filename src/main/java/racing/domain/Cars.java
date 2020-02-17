package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Cars {
	private static final int RANDOM_MAX = 9;
	private static final int RANDOM_MIN = 0;

	private List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars == null) {
			throw new IllegalArgumentException("List<Car>가 null입니다.");
		}

		this.cars = cars;
	}

	public int randomGenerate() {
		return ThreadLocalRandom.current()
				.ints(RANDOM_MIN, RANDOM_MAX)
				.findFirst()
				.orElse(RANDOM_MIN);
	}

	public void playRound() {
		cars.forEach(car -> car.goForward(randomGenerate()));
	}

	private int findWinnersPosition() {
		return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElse(0);
	}

	public List<String> findWinner() {
		return cars.stream()
				.filter(car -> car.isWinnerPosition(findWinnersPosition()))
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<String> getAllNames() {
		return getCars().stream()
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	public int getSize() {
		return cars.size();
	}
}
