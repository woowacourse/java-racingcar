package controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import constants.ErrorMessages;
import domain.Car;
import domain.Cars;
import domain.strategy.MovingStrategy;
import view.InputView;
import view.OutputView;

public class RacingGame {
	private static final String CAR_NAMES_DELIMITER = ",";
	private static final int INITIAL_LOCATION = 0;

	private final InputView inputView;
	private final OutputView outputView;
	private final MovingStrategy movingStrategy;

	public RacingGame(InputView inputView, OutputView outputView, MovingStrategy movingStrategy) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.movingStrategy = movingStrategy;
	}

	public void run() {
		String names = retryInputOnException(inputView::receiveNames);
		int trialCount = retryInputOnException(inputView::receiveTrialCount);

		Cars cars = loadCars(names);
		race(trialCount, cars);
		outputView.printWinners(cars.getLargestLocationCarNames());
	}

	private <T> T retryInputOnException(Supplier<T> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
			return retryInputOnException(supplier);
		}
	}

	private Cars loadCars(String carNames) {
		List<Car> carList = Arrays.stream(carNames.split(CAR_NAMES_DELIMITER))
			.map(name -> new Car(name, INITIAL_LOCATION, movingStrategy))
			.toList();

		return new Cars(carList);
	}

	private void race(int trialCount, Cars cars) {
		outputView.printResultPrefix();
		for (int i = 0; i < trialCount; i++) {
			cars.moveAll();
			outputView.printCurrentLocations(cars.getCurrentLocations());
		}
	}
}
