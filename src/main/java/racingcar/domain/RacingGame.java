package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.NumberGenerator;

public class RacingGame {
	private final NumberGenerator numberGenerator;
	List<Car> cars = RacingCars.getCars();

	public RacingGame(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void moveCars() {
		cars.forEach(car -> car.move(numberGenerator.generateNumber()));
	}

	public List<String> getWinners() {
		return cars.stream()
				.filter(car -> car.getPosition() == findMaxPosition())
				.map(Car::getName)
				.collect(Collectors.toList());
	}

	private int findMaxPosition() {
		return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
	}
}
