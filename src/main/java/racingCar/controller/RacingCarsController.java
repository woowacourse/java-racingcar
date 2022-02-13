package racingCar.controller;

import racingCar.service.RacingCarsService;
import racingCar.service.RequestService;
import racingCar.view.Output;

public class RacingCarsController {

	public void request() {
		RequestService.requestNames();
		RequestService.requestCount();
	}

	public void startGame() {
		RacingCarsService.runGame();
	}

	public void endGame() {
		Output.printWinner(RacingCarsService.findWinner());
	}
}
