package racingcargame.model;

import java.util.HashMap;
import java.util.List;

public class RacingCarGame {
	private static final int GAME_OVER_COUNT = 0;

	private Cars cars;
	private RaceCount raceCount;

	public RacingCarGame(List<String> racingCarNames, String raceCount) {
		prepareRacingCars(racingCarNames);
		prepareRaceCount(raceCount);
	}

	private void prepareRacingCars(final List<String> racingCarNames) {
		cars = new Cars(racingCarNames);
	}

	private void prepareRaceCount(final String raceCount) {
		this.raceCount = new RaceCount(raceCount);
	}

	public boolean isOverRace() {
		return raceCount.getCount() == GAME_OVER_COUNT;
	}

	public void startRace() {
		raceCount.reduceCount();
		cars.moveCars();
	}

	public HashMap<String, Integer> sendCurrentPositionOfRacingCars() {
		return cars.bringCarsPositionSeparatedByName();
	}

	public List<String> sendRacingGameWinner() {
		return cars.findWinner();
	}
}
