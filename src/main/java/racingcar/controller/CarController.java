package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

	public void playGame() {
		retryInitCarNames();
		int roundCount = retryReadingRoundCount();
		move(roundCount);
	}

	private void retryInitCarNames() {
		OutputView.printCarNameRequestMsg();
		try {
			List<String> carNames = InputView.readCarNames();
			carNames.stream()
				.forEach(carName -> CarRepository.add(new Car(carName)));
		} catch (Exception e) {
			OutputView.printErrorMsg(e.getMessage());
			retryInitCarNames();
		}
	}

	private int retryReadingRoundCount() {
		int roundCount = -1;
		OutputView.printRoundCountRequestMsg();
		try {
			roundCount = InputView.readRoundCount();
		} catch (Exception e) {
			OutputView.printErrorMsg(e.getMessage());
			retryReadingRoundCount();
		}
		return roundCount;
	}

	private void move(int roundCount) {
		CarService carService = new CarService(new RandomNumberGenerator());
		OutputView.printOutputMsg();
		OutputView.printRacingState(carService.getPositionToString());
		for (int i = 0; i < roundCount; i++) {
			carService.moveCars();
			OutputView.printRacingState(carService.getPositionToString());
		}
		OutputView.printRacingResult(carService.getWinners());
	}
}
