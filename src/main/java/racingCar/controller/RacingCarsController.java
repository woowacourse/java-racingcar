package racingCar.controller;

import racingCar.service.RacingCarService;
import racingCar.utlis.Convertor;
import racingCar.validator.CountValidator;
import racingCar.validator.NameValidator;
import racingCar.view.Input;
import racingCar.view.Output;

public class RacingCarsController {

	RacingCarService racingCarService = new RacingCarService();

	public void requestCarsName() {
		try {
			String input = Input.inputCarsName();
			NameValidator.checkNameInput(input);
			racingCarService.saveCars(input);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCarsName();
		}
	}

	public void requestCount() {
		try {
			String input = Input.inputCount();
			CountValidator.checkCountInput(input);
			int count = Convertor.convertStringToInteger(input);
			CountValidator.checkCountIsLessThanZero(count);
			racingCarService.saveCount(count);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	public void startGame() {
		racingCarService.runGame();
	}

	public void endGame() {
		Output.printWinner(racingCarService.findWinner());
	}

}
