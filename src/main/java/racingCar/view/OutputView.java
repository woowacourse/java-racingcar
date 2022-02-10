package racingCar.view;

import static racingCar.constants.RacingCarConstants.*;

import java.util.ArrayList;
import java.util.List;

import racingCar.domain.Car;

public class OutputView {
	public static void printError(String message) {
		System.out.println(message);
	}

	public static void startPrintResultMessage() {
		System.out.println(EXECUTION_RESULT_MESSAGE);
	}

	public static void printCars(ArrayList<Car> cars) {
		for (Car car : cars) {
			System.out.println(car);
		}
		printNewLine();
	}

	public static void printWinners(List<Car> winners) {
		for (int idx = 0; idx < winners.size() - 1; idx++) {
			winners.get(idx).printName();
			System.out.print(COLON_SPACE);
		}
		winners.get(winners.size() - 1).printName();
		System.out.println(FINAL_WINNER_MESSAGE);
	}

	private static void printNewLine() {
		System.out.println();
	}

}
