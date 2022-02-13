package racingCar.service;

import racingCar.exception.NullNameException;
import racingCar.utlis.Util;
import racingCar.view.Input;
import racingCar.view.Output;

public class RequestService {

	public static void requestNames() {
		try {
			String input = Input.inputNames();
			validateNotNullInput(input);
			RacingCarsService.initiateCars(input);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestNames();
		}
	}

	public static void requestCount() {
		try {
			String input = Input.inputCount();
			validateNotNullInput(input);
			RacingCarsService.initiateCount(Util.convertToInteger(input));
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	private static void validateNotNullInput(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty())
			throw new NullNameException();
	}
}
