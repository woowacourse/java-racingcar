package racingCar.view;

import static racingCar.constants.RacingCarConstants.*;

import java.util.List;

import racingCar.domain.Car;
import racingCar.domain.RacingCars;

public class OutputView {
	public static void printError(String message) {
		System.out.println(message);
	}

	public static void startPrintResultMessage() {
		System.out.println(EXECUTION_RESULT_MESSAGE);
	}

	public static void printCars(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + " : " + CAR_MOVE.repeat(Math.max(0, car.getPosition())));
		}
		printNewLine();
	}

	private static void printNewLine() {
		System.out.println();
	}

	public static void printWinners(List<Car> winners) {
		for (int idx = 0; idx < winners.size() - 1; idx++) {
			System.out.print(winners.get(idx).getName() + ", ");
		}
		System.out.print(winners.get(winners.size() - 1).getName());
		System.out.println(FINAL_WINNER_MESSAGE);
	}

}
