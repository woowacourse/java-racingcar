package racingCar.controller;

import static racingCar.view.Output.*;

import racingCar.service.RacingCarsService;
import racingCar.service.RequestService;
import racingCar.view.Output;

public class RacingCarsController {
	public RacingCarsController() {
		RacingCarsService.initiateCars(RequestService.requestNames());
		RacingCarsService.initiateCount(RequestService.requestCount());
	}

	public void startGame() {
		printStartMessage();
		RacingCarsService.runGame();
	}

	public void endGame() {
		Output.printWinner(RacingCarsService.findWinner());
	}
}
