package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
	private final List<Car> racingCars;

	public RacingCars(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public void moveRacingCars() {
		for (Car racingCar : this.racingCars) {
			racingCar.moveCar(makeRandomNumber());
		}
	}

	private boolean makeRandomNumber() {
		return ((int)(Math.random() * 10) - 1) >= 4;
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

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (Car racingCar : this.racingCars) {
			output.append(racingCar.toString()).append("\n");
		}
		return output.toString();
	}
}
