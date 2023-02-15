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
		getCarNames();
		int roundCount = getRoundCount();
		move(roundCount);
	}

	private void getCarNames() {
		try {
			OutputView.printCarNameRequestMsg();
			List<String> carNames = InputView.readCarNames();
			carNames.stream()
				.forEach(carName -> CarRepository.add(new Car(carName)));
		} catch (Exception e) {
			OutputView.printErrorMsg(e.getMessage());
			getCarNames();
		}
	}

	private int getRoundCount() {
		try {
			OutputView.printRoundCountRequestMsg();
			return InputView.readRoundCount();
		} catch (Exception e) {
			OutputView.printErrorMsg(e.getMessage());
			getRoundCount();
		}
		return -1;
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
