package racingcargame.model;

import java.util.HashMap;
import java.util.List;

public class RacingCarGame {
	private static final int GAME_OVER_COUNT = 0;

	private CarRepository carRepository;

	public RacingCarGame(List<String> racingCarNames, int raceCount) {
		prepareRacingCars(racingCarNames);
		prepareRaceCount(raceCount);
	}

	private void prepareRacingCars(final List<String> racingCarNames) {
		carRepository = new CarRepository(racingCarNames);
	}

	private void prepareRaceCount(final int raceCount) {
		RaceCount.storeCount(raceCount);
	}

	public boolean isOverRace() {
		return RaceCount.getCount() == GAME_OVER_COUNT;
	}

	public void startRace() {
		RaceCount.reduceRaceCount();
		carRepository.moveCars();
	}

	public HashMap<String, Integer> sendCurrentLocationOfRacingCars() {
		return carRepository.bringCarsNameAndPosition();
	}

	public List<String> sendRacingGameWinner() {
		return carRepository.findWinner();
	}
}
