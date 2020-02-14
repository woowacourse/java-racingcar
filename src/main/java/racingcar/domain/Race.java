package racingcar.domain;

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

	public String getWinnersName() {
		return cars.getWinnersName();
	}

	public String getCarsCurrentPosition() {
		return cars.getCurrentPosition();
	}
}
