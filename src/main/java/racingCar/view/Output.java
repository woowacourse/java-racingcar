package racingCar.view;

import java.util.List;

import racingCar.model.Car;

public class Output {

	static final String ERROR_MSG = "[ERROR]";
	static final String POSITION_SIGNATURE = "-";

	public static void printError(String e) {
		System.out.println(ERROR_MSG + e);
	}

	public static void printResultMessege() {
		System.out.println("\n실행 결과");
	}

	public static void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + " : " + POSITION_SIGNATURE.repeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinner(List<String> winner) {
		StringBuilder Result = new StringBuilder();
		for (String w : winner) {
			Result.append(w).append(", ");
		}
		System.out.println(Result.substring(0, Result.length() - 2)+"가 최종 우승했습니다.");
	}
}
