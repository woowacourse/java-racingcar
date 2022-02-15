package racingcar.controller;

import java.util.Arrays;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.trycount.TryCount;
import racingcar.util.MovableNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	private TryCount tryCount;
	private Cars cars = Cars.create();

	public RaceController() {
	}

	public void setUpCars() {
		try {
			String input = InputView.inputNamesUi();
			Arrays.stream(input.split(","))
				.map(Car::from)
				.forEach(cars::add);
			cars.validateIsEmpty();
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorUi(exception);
			setUpCars();
		}
	}

	public void setUpTryCount() {
		try {
			String input = InputView.inputTryCountUi();
			tryCount = TryCount.from(input);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorUi(exception);
			setUpTryCount();
		}
	}

	public void raceStart() {
		OutputView.printRaceResultUi();
		for (int i = 0; i < tryCount.toInt(); i++) {
			cars.race(new MovableNumber());
			OutputView.printCarsUi(cars.getCarsDto());
			OutputView.printEnterUi();
		}
	}

	public void raceEnd() {
		OutputView.printWinnersUi(cars.getWinnersNames());
	}

}
