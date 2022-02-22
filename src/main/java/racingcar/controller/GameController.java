package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
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
		MoveCount moveCount = getMoveCount();
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

	private MoveCount getMoveCount() {
		try {
			return new MoveCount(InputView.getMoveCount(scanner));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getMoveCount();
		}
	}

	private void startRace(Cars cars, MoveCount moveCount) {
		for (int i = 0; i < moveCount.toInt(); i++) {
			cars.startEachRace();
			OutputView.printCarPosition(cars.getCarsInfo());
		}
	}
}
