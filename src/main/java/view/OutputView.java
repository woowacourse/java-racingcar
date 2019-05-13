package view;

import java.util.List;
import java.util.stream.Collectors;

import racinggame.Car;
import racinggame.Cars;
import racinggame.Winners;

public class OutputView {
	private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
	private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

	public static void printStartMessage() {
		System.out.println(EXECUTION_RESULT_MESSAGE);
	}

	public static void printCars(Cars cars) {
		for (Car car : cars) {
			printCar(car);
		}
		System.out.println();
	}

	public static void printCar(Car car) {
		System.out.print(car.getName());
		System.out.print(" : ");
		for (int i = car.getPosition(); i > 0; i--) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void printNewline() {
		System.out.println();
	}

	public static void printIllegalArgumentMessage(String illegalArgumentMessage) {
		System.out.println(illegalArgumentMessage);
	}

	public static void printFinalWinner(Winners winners) {
		List<String> winnerStrings = winners.stream().map(car -> car.getName()).collect(Collectors.toList());

		String result = String.join(", ", winnerStrings) + FINAL_WINNER_MESSAGE;
		System.out.println(result);
	}
}
