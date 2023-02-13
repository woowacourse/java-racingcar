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
		while (!inputCarNames()) ;
		while (!inputRoundCount()) ;
		startRound(roundCount);
	}

	private boolean inputCarNames() {
		try {
			OutputView.printCarNameRequestMsg();
			List<String> carNames = InputView.readCarNames();
			carNames.stream().forEach(carName -> racingCars.add(new Car(carName)));
			return true;
		} catch (Exception e) {
			racingCars.clear();
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean inputRoundCount() {
		try {
			OutputView.printRoundCountRequestMsg();
			roundCount = InputView.readRoundCount();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
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
