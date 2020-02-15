package racingcar.domain;

public class Race {
	private final Cars cars;
	private final RaceCount raceCount;

	public Race(Cars cars, RaceCount raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public void run() {
		cars.moveAll();
		raceCount.increaseCurrentCount();
	}

	public boolean isEnd() {
		return raceCount.isEnd();
	}

	public Cars getCars() {
		return cars;
	}
}
