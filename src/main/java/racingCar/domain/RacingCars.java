package racingCar.domain;

import static racingCar.constants.RacingCarConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
	private final List<Car> racingCars;

	public RacingCars(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public void moveRacingCars() {
		for (Car racingCar : this.racingCars) {
			racingCar.moveCar(isRandomOverProbability());
		}
	}

	boolean isRandomOverProbability() {
		return ((int)(Math.random() * 10) - 1) >= GO_OR_NOT;
	}

	private int getMaxDistance() {
		int maxDistance = Integer.MIN_VALUE;
		for (Car racingCar : this.racingCars) {
			maxDistance = Math.max(maxDistance, racingCar.getPosition());
		}
		return maxDistance;
	}

	public List<Car> findWinner() {
		int maxDistance = getMaxDistance();
		List<Car> winners = new ArrayList<>();
		for (Car racingCar : this.racingCars) {
			winners = addWinner(maxDistance, winners, racingCar);
		}
		return winners;
	}

	private List<Car> addWinner(int maxDistance, List<Car> winners, Car racingCar) {
		if (racingCar.isWinner(maxDistance)) {
			winners.add(racingCar);
		}
		return winners;
	}

	public List<Car> getRacingCars() {
		return Collections.unmodifiableList(racingCars);
	}
}
