package racingcar.controller;

import static racingcar.view.Output.*;

import racingcar.service.RacingCarService;
import racingcar.utlis.Convertor;
import racingcar.validator.CountValidator;
import racingcar.validator.NameValidator;
import racingcar.view.Input;
import racingcar.view.Output;

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
