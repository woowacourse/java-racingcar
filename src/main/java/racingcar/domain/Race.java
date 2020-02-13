package racingcar.domain;

import java.util.List;

public class Race {
	private final Cars cars;
	private final RaceCount raceCount;
	private List<String> winnersName;

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
		winnersName = cars.getWinnersName(maxPosition);
	}

	public List<String> getWinnersName() {
		return winnersName;
	}
}
