package racingcar.controller;

import static racingcar.view.Output.*;

import java.util.stream.IntStream;

import racingcar.service.RacingCarService;
import racingcar.utlis.Convertor;
import racingcar.validator.CountValidator;
import racingcar.validator.NameValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarsController {

	private int roundCount = 0;
	private final RacingCarService racingCarService = new RacingCarService();

	public void requestCarsName() {
		try {
			String carsNames = Input.inputCarsName();
			NameValidator.checkNull(carsNames);
			racingCarService.saveCars(carsNames);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			racingCarService.resetCars();
			requestCarsName();
		}
	}

	public void requestCount() {
		try {
			String countString = Input.inputCount();
			CountValidator.checkInputString(countString);
			this.roundCount = Convertor.convertStringToInteger(countString);
			CountValidator.checkCountIsZero(roundCount);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	public void startGame() throws Exception {
		printResultMessage();
		runGame();
	}

	private void runGame() {
		IntStream.range(0, roundCount).forEach(i -> {
			racingCarService.playRound();
			printRoundResult(racingCarService.findAllCars());
		});
	}

	public void endGame() {
		Output.printWinner(racingCarService.findWinner());
	}

}
