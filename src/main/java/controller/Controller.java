package controller;

import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class Controller {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void run() {
		String carNames = inputView.askCars();
		RacingGame racingGame = new RacingGame(carNames);

		int trial = inputView.askTrial();
		outputView.printResultMessage();
		startRacing(trial, racingGame);
		outputView.printWinner(racingGame.getCars().winners());
	}

	public void startRacing(int trial, RacingGame racingGame) {
		for (int i = 0; i < trial; i++) {
			outputView.printCarsDistance(racingGame.moveCars());
		}
	}
}
