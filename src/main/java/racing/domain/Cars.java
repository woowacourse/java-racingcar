package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racing.view.OutputView;

public class Cars {
	private List<Car> cars;

	public Cars(List<String> carNames) {
		cars = carNames.stream()
				.map(Car::new)
				.collect(Collectors.toList());
	}

	public void playRound() {
		cars.forEach(car -> car.goForward(car.randomGenerate()));
	}

	private int findWinnersPosition() {
		return cars.stream()
				.map(Car::getPosition)
				.reduce(Integer::max)
				.orElse(0);
	}

	public List<Car> findWinner() {
		return cars.stream()
			.filter(car -> car.isWinner(findWinnersPosition()))
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
