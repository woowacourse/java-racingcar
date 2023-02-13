package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
	private final CarRepository carRepository = new CarRepository();
	private int roundCount;

	public void playGame() {
		while (!getCarNames())
			;
		while (!getRoundCount())
			;
		move();
	}

	private boolean getCarNames() {
		try {
			OutputView.printCarNameRequestMsg();
			final List<String> carNames = InputView.readCarNames();
			carNames.stream()
				.forEach(carName -> CarRepository.add(new Car(carName)));
			return true;
		} catch (Exception e) {
			CarRepository.clear();
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean getRoundCount() {
		try {
			OutputView.printRoundCountRequestMsg();
			roundCount = InputView.readRoundCount();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
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
