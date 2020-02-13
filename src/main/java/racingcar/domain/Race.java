package racingcar.domain;

public class Race {
	private final Cars cars;
	private final RaceCount raceCount;

	public Race(Cars cars, RaceCount raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public void run() {
		int maxPosition = 0;

		for (int i = 0; i < raceCount.getRaceCount(); i++) {
			cars.moveAll();
			maxPosition = cars.getMaxPosition(maxPosition);
		}
	}
}
