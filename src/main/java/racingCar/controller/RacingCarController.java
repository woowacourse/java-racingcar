package racingCar.controller;

import static racingCar.constants.RacingCarConstants.*;

import java.util.ArrayList;
import java.util.List;

import racingCar.domain.Car;
import racingCar.domain.RacingCars;
import racingCar.validator.RacingCarValidator;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingCarController {
	private RacingCars racingCars;
	private int times;

	public void start() {
		String[] carNames = getAndSeparateCarNames();
		getCarTimes();
		makeCars(carNames);
		race(times);
		OutputView.printWinners(racingCars.findWinner());
	}

	private String[] getAndSeparateCarNames() {
		String inputCarName = InputView.userStringInput(INPUT_CAR_NAME_MESSAGE);
		return separateCarNames(inputCarName);
	}

	public String[] separateCarNames(String input) {
		String[] carNames = input.split(COMMA);
		for (int idx = 0; idx < carNames.length; idx++) {
			carNames[idx] = carNames[idx].trim();
			checkCarName(carNames[idx]);
		}
		return carNames;
	}

	private void checkCarName(String name) {
		try {
			RacingCarValidator.isRightLength(name);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			getAndSeparateCarNames();
		}
	}

	private void getCarTimes() {
		String inputRacingTimes = InputView.userStringInput(INPUT_COUNT_MESSAGE);
		try {
			RacingCarValidator.isRightTimes(inputRacingTimes);
			times = Integer.parseInt(inputRacingTimes);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			getCarTimes();
		}
	}

	private void makeCars(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		racingCars = new RacingCars(cars);
	}

	public void race(int count) {
		OutputView.startPrintResultMessage();
		for (int i = 0; i < count; i++) {
			racingCars.moveRacingCars();
			OutputView.printCars(racingCars);
		}
	}
}
