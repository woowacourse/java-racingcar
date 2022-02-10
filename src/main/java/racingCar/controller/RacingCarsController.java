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
			String carsNames = Input.inputCarsName();
			NameValidator.checkNull(carsNames);
			racingCarService.saveCars(carsNames);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCarsName();
		}
	}

	public void requestCount() {
		try {
			String countString = Input.inputCount();
			CountValidator.checkNull(countString);
			CountValidator.checkNotNumber(countString);
			int count = Convertor.convertStringToInteger(countString);
			CountValidator.checkCountIsZero(count);
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
