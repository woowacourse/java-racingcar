package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

import racing.view.OutputView;

public class Cars {
	private List<Car> cars;

	public Cars(List<String> input) {
		cars = input.stream()
				.map(Car::new)
				.collect(Collectors.toList());
	}

	public int size() {
		return cars.size();
	}

	public List<String> getAllNames() {
		return cars.stream()
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	public List<Car> findWinner() {
		return cars.stream()
			.filter(car -> car.isWinner(findWinnersPosition()))
			.collect(Collectors.toList());
	}

	private int findWinnersPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.reduce(Integer::max)
			.orElse(0);
	}

	public void playRound() {
		cars.forEach(car -> car.goForward(car.randomGenerate()));
	}

	public void printPosition() {
		OutputView.printAllPosition(cars);
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
