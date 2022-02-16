package racingcar.domain;

import java.util.Set;

public class Game {
	private static final int MOVE_CRITERIA = 4;
	private static final int RANDOM_VALUE_BOUND = 9;

	private final UniqueCars uniqueCars;

	public Game(UniqueCars uniqueCars) {
		this.uniqueCars = uniqueCars;
	}

	public UniqueCars play() {
		for (Car car : uniqueCars.getCars()) {
			moveCar(car);
		}
		return uniqueCars;
	}

	private void moveCar(Car car) {
		if (Random.makeRandomValue(RANDOM_VALUE_BOUND) >= MOVE_CRITERIA) {
			car.move();
		}
	}

	public Set<Car> getWinners() {
		return uniqueCars.getCarsInPosition(uniqueCars.getMaxPosition());
	}
}
