package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.validator.MoveCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class GameController {
	private final Scanner scanner;

	public GameController(Scanner scanner) {
		this.scanner = scanner;
	}

	public void run() {
		Cars cars = getCars();
		int moveCount = getMoveCount();
		OutputView.printResultMessage();
		startRace(cars, moveCount);
		OutputView.printWinners(cars.getWinners().getNames());
	}

	private Cars getCars() {
		try {
			String[] carNames = InputView.getCarNames(scanner);
			return new Cars(carNames);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getCars();
		}
	}

	private int getMoveCount() {
		try {
			int moveCount = InputView.getMoveCount(scanner);
			MoveCountValidator.validateMoveCount(moveCount);
			return moveCount;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getMoveCount();
		}
	}

	private void startRace(Cars cars, int moveCount) {
		for (int i = 0; i < moveCount; i++) {
			cars.startEachRace();
			OutputView.printCarPosition(cars.getCarsInfo());
		}
	}
}
