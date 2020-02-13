package racingcar.domain;

import racingcar.controller.RaceController;

public class Race {
	private static final int INITIAL_POSITION = 0;

	private final Cars cars;
	private final RaceCount raceCount;

	public Race(Cars cars, RaceCount raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public void run() {
		int maxPosition = INITIAL_POSITION;

		RaceController.showRaceStart();

		for (int i = 0; i < raceCount.getRaceCount(); i++) {
			cars.moveAll();
			RaceController.showCurrentPosition(cars.getCurrentPosition());
			maxPosition = cars.getMaxPosition(maxPosition);
		}

		RaceController.showWinnersName(cars.getWinnersName(maxPosition));
	}
}
