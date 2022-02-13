package racingCar.service;

import racingCar.exception.NullInputException;
import racingCar.utlis.Util;
import racingCar.view.Input;

public class RequestService {

	public static void requestNames() {
		String input = Input.inputNames();
		validateNotNullInput(input);
		RacingCarsService.initiateCars(input);
	}

	public static void requestCount() {
		String input = Input.inputCount();
		validateNotNullInput(input);
		RacingCarsService.initiateCount(Util.convertToInteger(input));
	}

	private static void validateNotNullInput(String inputString) {
		if (inputString == null || inputString.isEmpty())
			throw new NullInputException();
	}
}
