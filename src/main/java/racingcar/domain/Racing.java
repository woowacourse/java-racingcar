package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Racing {
	private final List<Car> cars;
	private final Count count;

	public Racing(List<Car> cars, Count count) {
		this.cars = cars;
		this.count = count;
	}

	public boolean isEnd() {
		return !count.isPositive();
	}

	public List<Car> race() {
		count.subtract();
		moveCars(cars);

		return cars;
	}

	private void moveCars(List<Car> cars) {
		cars.forEach(Car::move);
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition(cars);

		return cars.stream()
			.filter(car -> maxPosition == car.getPosition())
			.map(Car::getName)
			.collect(toList());
	}

	private int getMaxPosition(List<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}
}
