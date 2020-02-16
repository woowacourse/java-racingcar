package racingcargame;

import racingcargame.domain.Cars;
import racingcargame.domain.TryNumber;
import racingcargame.domain.Winners;
import racingcargame.exception.CarNameInputException;
import racingcargame.exception.CarsNameInputException;
import racingcargame.exception.InvalidTryNumberException;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class RacingGameApplication {
	public static void main(String[] args) {
		Cars cars = inputCars();

		TryNumber tryNumber = inputTryNumber();

		doMoveCycle(cars, tryNumber);

		Winners winners = new Winners(cars.extractWinners());
		OutputView.printWinners(winners);
	}

	private static Cars inputCars() {
		try {
			String inputCarNames = InputView.inputCarNames();
			return Cars.create(inputCarNames);
		} catch (CarsNameInputException | CarNameInputException e) {
			return inputCars();
		}
	}

	private static TryNumber inputTryNumber() {
		try {
			String tryNumberInput = InputView.inputTryNumber();
			return new TryNumber(tryNumberInput);
		} catch (InvalidTryNumberException e) {
			OutputView.printInvalidTryNumberErrorMessage();
			return inputTryNumber();
		}
	}

	private static void doMoveCycle(Cars cars, TryNumber tryNumber) {
		OutputView.printHead();
		int number = 0;
		while (tryNumber.isBiggerThan(number)) {
			cars.move();
			OutputView.printPositions(cars);
			number++;
		}
	}
}
