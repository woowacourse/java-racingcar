package racingCar.service;

import racingCar.utlis.Convertor;
import racingCar.validator.CountValidator;
import racingCar.validator.NameValidator;
import racingCar.view.Input;
import racingCar.view.Output;

public class RequestService {

	public static void requestNames(RacingCarsService carsService) {
		try {
			String input = Input.inputNames();
			NameValidator.validateInput(input);
			carsService.initiateCars(input);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestNames(carsService);
		}
	}

	public static void requestCount(RacingCarsService carsService) {
		try {
			String input = Input.inputCount();
			CountValidator.validateInput(input);
			carsService.initiateCount(Convertor.convertToInteger(input));
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount(carsService);
		}
	}
}
