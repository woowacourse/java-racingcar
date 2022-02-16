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

	public void start() {
		requestCarNames();
		requestCount();
		startGame();
		endGame();
	}

	private void requestCarNames() {
		String carNames = Input.inputCarNames();
		try {
			NameValidator.checkNull(carNames);
			saveCarNames(carNames);
		} catch (Exception exception) {
			printError(exception.getMessage());
			requestCarNames();
		}
	}

	private void saveCarNames(String carNames) {
		try {
			racingCarService.saveCars(carNames);
		} catch (Exception exception) {
			printError(exception.getMessage());
			requestCarNames();
		}
	}

	private void requestCount() {
		String count = Input.inputCount();
		validateCount(count);
	}

	private void validateCount(String count) {
		try {
			CountValidator.checkInputString(count);
			this.roundCount = Convertor.convertStringToInteger(count);
			CountValidator.checkCountIsZero(roundCount);
		} catch (Exception exception) {
			Output.printError(exception.getMessage());
			requestCount();
		}
	}

	private void startGame() {
		printResultMessage();
		runGame();
	}

	private void runGame() {
		IntStream.range(0, roundCount).forEach(i -> {
			racingCarService.playRound();
			printRoundResult(racingCarService.findAllCars());
		});
	}

	private void endGame() {
		Output.printWinners(racingCarService.findWinner());
	}

}
