package racingcar.controller;

import static racingcar.view.Output.*;

import java.util.ArrayList;
import java.util.stream.IntStream;

import racingcar.model.Cars;
import racingcar.model.RoundCount;
import racingcar.service.RacingCarService;
import racingcar.validator.NameValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarsController {

	private RoundCount roundCount;
	private Cars cars;
	private RacingCarService racingCarService;

	public RacingCarsController() {
		cars = new Cars();
		racingCarService = new RacingCarService(new ArrayList<>());
	}

	public void start() {
		requestCarNames();
		requestCount();
		startGame();
		endGame();
	}

	private void requestCarNames() {
		String carNames = Input.inputCarNames();
		try {
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
		try {
			roundCount=new RoundCount(Input.inputCount());
		}catch (Exception exception){
			printError(exception.getMessage());
			requestCount();
		}
	}

	private void startGame() {
		printResultMessage();
		runGame();
	}

	private void runGame() {
		IntStream.range(0, roundCount.getRoundCount()).forEach(i -> {
			racingCarService.playRound();
			printRoundResult(racingCarService.findAllCars());
		});
	}

	private void endGame() {
		Output.printWinners(racingCarService.findWinner());
	}

}
