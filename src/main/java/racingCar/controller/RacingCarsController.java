package racingCar.controller;

import static racingCar.view.Output.*;

import racingCar.service.RacingCarsService;
import racingCar.service.RequestService;
import racingCar.view.Output;

public class RacingCarsController {
	private final RacingCarsService racingCarsService = new RacingCarsService();

	public RacingCarsController() {
		racingCarsService.initiateCars(RequestService.requestNames());
		racingCarsService.initiateCount(RequestService.requestCount());
	}

	public void startGame() {
		printStartMessage();
		racingCarsService.runGame();
	}

	public void endGame() {
		Output.printWinner(racingCarsService.findWinner());
	}
}