package racingcar.controller;

import racingcar.models.CarRepository;
import racingcar.views.Output;

public class RacingGame {

	private final CarRepository carRepository;
	private int repeats;

	public RacingGame(final String names, final int repeats) {
		carRepository = new CarRepository(names);
		this.repeats = repeats;
	}

	public void startGame() {
		startRacing();
	}

	private void startRacing() {
		Output.printResultMessage();
		while(repeats-- > 0) {
			carRepository.startThisTurn();
			Output.printTurnResult(carRepository.getThisTurnResult());
		}
		Output.printWinner(carRepository.getWinners());
	}

}
