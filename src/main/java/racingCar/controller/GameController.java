package racingCar.controller;

import static racingCar.view.Output.*;

import racingCar.service.RacingCarsService;
import racingCar.service.RequestService;
import racingCar.view.Output;

public class GameController {
	private final RacingCarsService racingCarsService = new RacingCarsService();

	public void run() {
		racingCarsService.initiateCars(RequestService.requestNames());
		racingCarsService.initiateCount(RequestService.requestCount());
		playGame();
		endGame();
	}

	public void playGame() {
		printStartMessage();
		racingCarsService.playGame();
	}

	public void endGame() {
		Output.printWinner(racingCarsService.getWinnerCars());
	}
}