package racingcar.controller;

import static racingcar.view.Output.*;

import java.util.ArrayList;
import java.util.stream.IntStream;

import racingcar.service.RacingCarService;
import racingcar.utlis.Convertor;
import racingcar.validator.CountValidator;
import racingcar.validator.NameValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarsController {

	private int roundCount = 0;
	private final RacingCarService racingCarService = new RacingCarService(new ArrayList<>());

	public void requestCarsName() {
		try {
			String carNames = Input.inputCarsName();
			NameValidator.checkNull(carNames);
			racingCarService.saveCars(carNames);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			racingCarService.resetCars();
			requestCarsName();
		}
	}

	public void requestCount() {
		try {
			String count = Input.inputCount();
			CountValidator.checkInputString(count);
			this.roundCount = Convertor.convertStringToInteger(count);
			CountValidator.checkCountIsZero(roundCount);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	public void startGame() {
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
