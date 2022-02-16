package racingcar.domain;

import java.util.Collection;

public class Game {
	private final Cars cars;

	public Game(Cars cars) {
		this.cars = cars;
	}

	public Cars play(MoveStrategy moveStrategy) {
		cars.getCars().stream()
			.filter(car -> moveStrategy.isMovable())
			.forEach(Car::move);
		return cars;
	}

	public Collection<Car> getWinners() {
		return cars.getCarsInPosition(cars.getMaxPosition());
	}
}
