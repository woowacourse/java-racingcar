package racingcar.models;

import java.util.List;

public class RacingGame {

	private final CarRepository carRepository;
	private int repeats;

	public RacingGame(final String names, final int repeats) {
		carRepository = new CarRepository(names);
		this.repeats = repeats;
	}

	public boolean isEnd() {
		return repeats <= 0;
	}

	public void endThisTurn() {
		repeats--;
	}

	public void race() {
		carRepository.startThisTurn();
	}

	public List<Car> getThisTurnResult() {
		return carRepository.getThisTurnResult();
	}

	public List<String> getWinnersName() {
		return carRepository.getWinnersName();
	}
}
