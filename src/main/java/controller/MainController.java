package controller;

import racinggame.Cars;
import racinggame.RacingGame;
import racinggame.RacingGameMovingStrategy;
import racinggame.RandomRacingGameMovingStrategy;
import racinggame.Winners;
import view.InputView;
import view.OutputView;

public class MainController {
	private static final int MIN_ROUND = 1;
	private static final int MOVE_BOUND = 4;
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;

	public static void main(String[] args) {
		RacingGameMovingStrategy racingGameMovingStrategy =
				new RandomRacingGameMovingStrategy(RANDOM_MIN, RANDOM_MAX, MOVE_BOUND);

		RacingGame racingGame = getRacingGame(racingGameMovingStrategy);
		int totalRound = getTotalRound();
		
		OutputView.printStartMessage();
		
		Cars cars = null;
		
		for (int i = 0; i < totalRound; i++) {
			cars = racingGame.playOneRound();
			OutputView.printCars(cars);
		}

		Winners winners = new Winners(cars);
		OutputView.printFinalWinner(winners);
	}
	
	public static RacingGame getRacingGame(RacingGameMovingStrategy racingGameMovingStrategy) {
		String[] carNames = InputView.inputCarNames().replaceAll(" ", "").split(",");
		
		try {
			return new RacingGame(carNames, racingGameMovingStrategy);
		} catch (IllegalArgumentException e) {
			OutputView.printIllegalArgumentMessage(e.getMessage());
			return getRacingGame(racingGameMovingStrategy);
		}
	}

	public static int getTotalRound() {
		try {
			int totalRound = InputView.inputTotalRound();

			if (totalRound < MIN_ROUND) {
				OutputView.printIllegalRound();
				return getTotalRound();
			}

			return totalRound;
		} catch (NumberFormatException e) {
			OutputView.printIllegalNumber();
			return getTotalRound();
		}
	}
}
