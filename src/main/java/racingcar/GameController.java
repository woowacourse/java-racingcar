package racingcar;

import racingcar.domain.Cars;
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
		int moveCount = Integer.parseInt(InputView.getMoveCount(scanner));
		OutputView.printResultMessage();
		startRace(cars, moveCount);
		OutputView.printWinners(cars.getWinners());
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

	private void startRace(Cars cars, int moveCount) {
		for (int i = 0; i < moveCount; i++) {
			cars.startEachRace();
			OutputView.printCarPosition(cars.getAllPosition());
		}
	}
}
