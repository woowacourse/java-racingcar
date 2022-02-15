package racingcar.domain;

import java.util.Set;

public class Game {
	private static final int MOVE_CRITERIA = 4;
	private static final int RANDOM_VALUE_BOUND = 9;

	private final RacingCars racingCars;

	public Game(RacingCars racingCars) {
		this.racingCars = racingCars;
	}

	public RacingCars play() {
		for (Car car : racingCars.getCars()) {
			moveCar(car);
		}
		return racingCars;
	}

	private void moveCar(Car car) {
		if (Random.makeRandomValue(RANDOM_VALUE_BOUND) >= MOVE_CRITERIA) {
			car.move();
		}
	}

	public Set<Car> getWinners() {
		return racingCars.getCarsInPosition(racingCars.getMaxPosition());
	}
}
