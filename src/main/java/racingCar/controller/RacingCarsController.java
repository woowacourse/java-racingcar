package racingCar.controller;

import racingCar.service.RacingCarsService;
import racingCar.service.RequestService;
import racingCar.view.Output;

public class RacingCarsController {
	public RacingCarsController() {
		RacingCarsService.initiateCars(RequestService.requestNames());
		RacingCarsService.initiateCount(RequestService.requestCount());
	}

	public void startGame() {
		RacingCarsService.runGame();
	}

	public void endGame() {
		Output.printWinner(RacingCarsService.findWinner());
	}
}
