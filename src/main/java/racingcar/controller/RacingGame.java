package racingcar.controller;

import racingcar.models.CarRepository;
import racingcar.views.Input;
import racingcar.views.Output;

public class RacingGame {

	private CarRepository carRepository;
	private int repeats;

	public RacingGame() {
		repeats = 0;
	}

	public void startGame() {
		inputValidData();
		startRacing();
	}

	private void inputValidData() {
		createCar();
		repeats = Input.inputValidRepeats();
	}

	private void createCar() {
		final String carNames = Input.inputValidNames();
		carRepository = new CarRepository(carNames);
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
