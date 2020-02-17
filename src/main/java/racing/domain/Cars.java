package racing.domain;

import racing.utils.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars == null) {
			throw new IllegalArgumentException("List<Car>가 null입니다.");
		}

		this.cars = cars;
	}

	public void playRound(NumberGenerator numberGenerator) {
		for (Car car : cars) {
			car.goForward(numberGenerator.getNumber());
		}
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
