package racingCar.controller;

import static racingCar.view.Output.*;

import racingCar.service.RacingCarService;
import racingCar.utlis.Convertor;
import racingCar.validator.CountValidator;
import racingCar.validator.NameValidator;
import racingCar.view.Input;
import racingCar.view.Output;

public class RacingCarsController {

	private int roundCount = 0;
	private final RacingCarService racingCarService;

	public RacingCarsController() {
		this.racingCarService = new RacingCarService();
	}

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
			CountValidator.checkInputString(countString);
			this.roundCount = Convertor.convertStringToInteger(countString);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	public void startGame() throws Exception {
		CountValidator.checkCountIsZero(roundCount);
		printResultMessage();
		for (int i = 0; i < roundCount; i++) {
			racingCarService.runRound();
			Output.printRoundResult(racingCarService.findAllCars());
		}
	}

	public void endGame() {
		Output.printWinner(racingCarService.findWinner());
	}

}
