package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingCars;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
	private RacingCars racingCars = new RacingCars();
	int roundCount;

	public void run() {
		while (!isValidCarNames()) ;
		while (!isValidRoundCount()) ;
		startRound(roundCount);
	}

	private boolean isValidCarNames() {
		try {
			addToRacingCars(inputCarNames());
			return true;
		} catch (Exception e) {
			racingCars.clear();
			System.out.println(e.getMessage());
			return false;
		}
	}

	private List<String> inputCarNames() {
		OutputView.printCarNameRequestMsg();
		return InputView.readCarNames();
	}

	private void addToRacingCars(List<String> carNames) {
		carNames.forEach(carName -> racingCars.add(new Car(carName)));
	}

	private boolean isValidRoundCount() {
		try {
			roundCount = inputRoundCount();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private int inputRoundCount() {
		OutputView.printRoundCountRequestMsg();
		return InputView.readRoundCount();
	}

	private void startRound(int roundCount) {
		RacingGame racingGame = new RacingGame(new RandomNumberGenerator());
		OutputView.printRoundResultMsg();
		OutputView.printRoundState(racingCars.getCars());
		for (int i = 0; i < roundCount; i++) {
			racingGame.moveCars();
			OutputView.printRoundState(racingCars.getCars());
		}
		OutputView.printRacingResult(racingGame.getWinners());
	}
}
