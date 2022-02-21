package racingCar.domain;

import static racingCar.constants.RacingCarConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
	private final List<Car> racingCars;

	public RacingCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		this.racingCars = cars;
	}

	public void moveRacingCars() {
		for (Car racingCar : this.racingCars) {
			racingCar.moveCar(isRandomOverProbability());
		}
	}

	private boolean isRandomOverProbability() {
		return ((int)(Math.random() * 10)) >= GO_OR_NOT;
	}

	public List<Car> findWinner() {
		int maxDistance = getMaxDistance();
		List<Car> winners = new ArrayList<>();
		for (Car racingCar : this.racingCars) {
			addWinner(maxDistance, winners, racingCar);
		}
		return winners;
	}

	private int getMaxDistance() {
		int maxDistance = Integer.MIN_VALUE;
		for (Car racingCar : this.racingCars) {
			maxDistance = Math.max(maxDistance, racingCar.getPosition());
		}
		return maxDistance;
	}

	private void addWinner(int maxDistance, List<Car> winners, Car racingCar) {
		if (racingCar.isWinner(maxDistance)) {
			winners.add(racingCar);
		}
	}

	public List<Car> getRacingCars() {
		return Collections.unmodifiableList(racingCars);
	}
}
