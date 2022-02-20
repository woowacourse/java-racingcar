package racingcar.models;

import java.util.List;

public class RacingGame {

	private final CarRepository carRepository;
	private int repeats;

	public RacingGame(final String names, final int repeats,
			final String nameDistributor) {
		carRepository = new CarRepository(names, nameDistributor);
		this.repeats = repeats;
	}

	public boolean isEnd() {
		return repeats <= 0;
	}

	public void race() {
		carRepository.startThisTurn();
		repeats--;
	}

	public List<Car> getThisTurnResult() {
		return carRepository.getThisTurnResult();
	}

	public List<String> getWinnersName() {
		return carRepository.getWinnersName();
	}
}
