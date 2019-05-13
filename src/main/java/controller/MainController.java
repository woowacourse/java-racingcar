package controller;

import racinggame.Cars;
import racinggame.RacingGame;
import racinggame.RacingGameMovingStrategy;
import racinggame.RandomRacingGameMovingStrategy;
import racinggame.Winners;
import view.InputView;
import view.OutputView;

public class MainController {
	private static final int MOVE_BOUND = 4;
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;

	public static void main(String[] args) {
		RacingGameMovingStrategy racingGameMovingStrategy = 
				new RandomRacingGameMovingStrategy(RANDOM_MIN, RANDOM_MAX, MOVE_BOUND);

		String[] carNames = InputView.inputCarNames();
		int totalRound = InputView.inputTotalRound();

		RacingGame racingGame = new RacingGame(carNames, totalRound, racingGameMovingStrategy);
		OutputView.printStartMessage();

		Cars cars = null;

		while (!racingGame.isFinished()) {
			cars = racingGame.playNextRound();
			OutputView.printCars(cars);
		}

		Winners winners = new Winners(cars);
		OutputView.printFinalWinner(winners);
	}
}