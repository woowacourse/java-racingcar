package racingCar.controller;

import static racingCar.constants.RacingCarConstants.*;

import java.util.ArrayList;
import java.util.List;

import racingCar.domain.Car;
import racingCar.domain.RacingCars;
import racingCar.validator.RacingCarNameValidator;
import racingCar.validator.RacingCarTimeValidator;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingCarController {

	public void start() {
		RacingCars racingCars;
		String[] carNames = getSplitCarNames();
		racingCars = makeCars(carNames);
		race(getCarTimes(), racingCars);
		OutputView.printWinners(racingCars.findWinner());
	}

	private String[] getSplitCarNames() {
		String inputCarName = InputView.userStringInput(INPUT_CAR_NAME_MESSAGE);
		try {
			RacingCarNameValidator.isRightInput(inputCarName);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			return getSplitCarNames();
		}
		return separateCarNames(inputCarName);
	}

	private String[] separateCarNames(String input) {
		System.out.println(input);
		String[] carNames = input.split(SPLIT_COMMA);
		for (int idx = 0; idx < carNames.length; idx++) {
			carNames[idx] = carNames[idx].trim();
			checkCarName(carNames[idx]);
		}
		return carNames;
	}

	private void checkCarName(String name) {
		try {
			RacingCarNameValidator.isRightLength(name);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			getSplitCarNames();
		}
	}

	private int getCarTimes() {
		String inputRacingTimes = InputView.userStringInput(INPUT_COUNT_MESSAGE);
		try {
			RacingCarTimeValidator.isRightTimes(inputRacingTimes);
			return Integer.parseInt(inputRacingTimes);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			return getCarTimes();
		}
	}

	private RacingCars makeCars(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return new RacingCars(cars);
	}

	private void race(int count, RacingCars racingCars) {
		OutputView.startPrintResultMessage();
		for (int i = 0; i < count; i++) {
			racingCars.moveRacingCars();
			OutputView.printCars(racingCars);
		}
	}
}
