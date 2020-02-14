package racingcar.domain;

import java.util.List;

public class Race {
	private static final int INITIAL_ROUND = 1;

	private final Cars cars;
	private final RaceCount raceCount;
	private int currentRound;

	public Race(Cars cars, RaceCount raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
		this.currentRound = INITIAL_ROUND;
	}

	public void run() {
		cars.moveAll();
		currentRound++;
	}

	public boolean isProgress() {
		return raceCount.isProgressingRound(currentRound);
	}

	public List<Car> getWinners() {
		return cars.getWinners();
	}

	public List<Car> getCars() {
		return cars.getCars();
	}
}
