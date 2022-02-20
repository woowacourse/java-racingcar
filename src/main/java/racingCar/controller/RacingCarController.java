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
		List<String> carNames = getSplitCarNames();
		racingCars = makeCars(carNames);
		racingCars.race(getCarTimes());
		OutputView.printWinners(racingCars.findWinner());
	}

	private List<String> getSplitCarNames() {
		String inputCarName = InputView.userStringInput(INPUT_CAR_NAME_MESSAGE);
		try {
			RacingCarNameValidator.isRightInput(inputCarName);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			return getSplitCarNames();
		}
		return separateCarNames(inputCarName);
	}

	private List<String> separateCarNames(String input) {
		List<String> carNames = List.of(input.split(SPLIT_COMMA));
		for (String carName : carNames) {
			carName = carName.trim();
			checkCarName(carName);
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

	private RacingCars makeCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return new RacingCars(cars);
	}
}
