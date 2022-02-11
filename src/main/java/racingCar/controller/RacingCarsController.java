package racingCar.controller;

import racingCar.service.RacingCarsService;
import racingCar.service.RequestService;
import racingCar.utlis.Convertor;
import racingCar.validator.CountValidator;
import racingCar.validator.NameValidator;
import racingCar.view.Input;
import racingCar.view.Output;

public class RacingCarsController {
	RacingCarsService carsService = new RacingCarsService();

	public void request() {
		RequestService.requestNames(carsService);
		RequestService.requestCount(carsService);
	}

	public void startGame() {
		carsService.runGame();
	}

	public void endGame() {
		Output.printWinner(carsService.findWinner());
	}
}
