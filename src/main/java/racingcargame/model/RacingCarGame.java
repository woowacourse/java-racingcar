package racingcargame.model;

import java.util.*;

public class RacingCarGame {
	private CarRepository carRepository;

	public RacingCarGame(List<String> carNames, int raceCount) {
		prepareRacingCars(carNames);
		prepareRaceCount(raceCount);
	}

	private void prepareRacingCars(final List<String> carNames) {
		carRepository = new CarRepository(carNames);
	}

	private void prepareRaceCount(final int raceCount) {
		RaceCount.storeCount(raceCount);
	}

	public boolean isOverRace() {
		return RaceCount.getCount() == 0;
	}

	public void startRace() {
		RaceCount.reduceRaceCount();
		carRepository.moveCars();
	}

	public HashMap<String, Integer> sendCurrentLocationOfCars() {
		return carRepository.bringCarsNameAndPosition();
	}

	public List<String> findRacingGameWinner() {
		return carRepository.findWinner();
	}
}
