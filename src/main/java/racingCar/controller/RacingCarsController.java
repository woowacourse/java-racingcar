package racingCar.controller;

import racingCar.service.RacingCarsService;
import racingCar.utlis.Convertor;
import racingCar.validator.CountValidator;
import racingCar.validator.NameValidator;
import racingCar.view.Input;
import racingCar.view.Output;

public class RacingCarsController {

	RacingCarsService carsService = new RacingCarsService();

	public void requestNames() {
		try {
			String input = Input.inputNames();
			NameValidator.validateInput(input);
			carsService.initiateCars(input);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestNames();
		}
	}

	public void requestCount() {
		try {
			String input = Input.inputCount();
			CountValidator.validateInput(input);
			int count = Convertor.convertToInteger(input);
			CountValidator.validateInteger(count);
			carsService.saveCount(count);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	public void startGame() {
		carsService.runGame();
	}

	public void endGame() {
		Output.printWinner(carsService.findWinner());
	}

}
