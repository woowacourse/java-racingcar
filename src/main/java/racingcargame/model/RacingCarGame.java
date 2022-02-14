package racingcargame.model;

import java.util.HashMap;
import java.util.List;

public class RacingCarGame {
	private static final int GAME_OVER_COUNT = 0;

	private Cars cars;

	public RacingCarGame(List<String> racingCarNames, int raceCount) {
		prepareRacingCars(racingCarNames);
		prepareRaceCount(raceCount);
	}

	private void prepareRacingCars(final List<String> racingCarNames) {
		cars = new Cars(racingCarNames);
	}

	private void prepareRaceCount(final int raceCount) {
		RaceCount.storeCount(raceCount);
	}

	public boolean isOverRace() {
		return RaceCount.getCount() == GAME_OVER_COUNT;
	}

	public void startRace() {
		RaceCount.reduceRaceCount();
		cars.moveCars();
	}

	public HashMap<String, Integer> sendCurrentLocationOfRacingCars() {
		return cars.bringCarsPositionSeparatedByName();
	}

	public List<String> sendRacingGameWinner() {
		return cars.findWinner();
	}
}
