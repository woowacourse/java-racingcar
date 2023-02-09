package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

	private CarRepository carRepository = new CarRepository();
	private CarService carService = new CarService(new RandomNumberGenerator());

	public void run() {
		getCarNames();
		int roundCount = getRoundCount();
		move(roundCount);
	}

	private void getCarNames() {
		while(true) {
			try {
				OutputView.printCarNameRequestMsg();
				List<String> carNames = InputView.readCarNames();
				for (String carName : carNames) {
					carRepository.add(new Car(carName));
                }
				break;
			} catch (Exception e) {
				carRepository.clear();
				System.out.println(e.getMessage());
			}
		}
	}

	private int getRoundCount() {
		int roundCount;
		while(true) {
			try {
				OutputView.printRoundCountRequestMsg();
				roundCount = InputView.readRoundCount();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return roundCount;
	}

	private void move(int roundCount) {
		OutputView.printOutputMsg();
		OutputView.printRacingState(carRepository.getPositionToString());
		for (int i = 0; i < roundCount; i++) {
			carService.moveCars();
			OutputView.printRacingState(carRepository.getPositionToString());
		}
		OutputView.printRacingResult(carService.getWinners());
	}
}
