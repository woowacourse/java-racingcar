package racinggame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import view.OutputView;

public class RacingGame {
	private final Cars cars;
	private final RacingGameMovingStrategy racingGameMovingStrategy;
	private int totalRound;
	private int currentRound = 0;

	public RacingGame(String[] carNames, int totalRound, RacingGameMovingStrategy racingGameMovingStrategy) {
		this.cars = new Cars(Arrays.stream(carNames).map(name -> new Car(name)).collect(Collectors.toList()));
		this.racingGameMovingStrategy = racingGameMovingStrategy;
		this.totalRound = totalRound;
	}

	public Cars playNextRound() {
		for (Car car : cars) {
			car.move(racingGameMovingStrategy.movable());
		}

		currentRound++;

		return cars;
	}

	public boolean isFinished() {
		return totalRound <= currentRound;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RacingGame other = (RacingGame) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		return true;
	}
}
