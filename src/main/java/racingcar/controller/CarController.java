package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
	private int roundCount;

	public void playGame() {
		getCarNames();
		getRoundCount();
		move();
	}

	private void getCarNames() {
		try {
			OutputView.printCarNameRequestMsg();
			List<String> carNames = InputView.readCarNames();
			carNames.stream()
				.forEach(carName -> CarRepository.add(new Car(carName)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			getCarNames();
		}
	}

	private void getRoundCount() {
		try {
			OutputView.printRoundCountRequestMsg();
			roundCount = InputView.readRoundCount();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			getRoundCount();
		}
	}

	private void move() {
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
