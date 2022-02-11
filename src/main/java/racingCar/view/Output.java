package racingCar.view;

import java.util.List;

import racingCar.model.Car;

public class Output {

	static final String ERROR_MESSAGE = "[ERROR]";
	static final String POSITION_SIGNATURE = "-";
	public static final String RESULT_FRONT_MESSAGE = "\n실행 결과";
	public static final String WINNER_REGEX = ", ";
	public static final String WINNER_RESULT_LAST_MESSAGE = "가 최종 우승했습니다.";
	public static final String ROUND_REGEX = " : ";

	public static void printError(String e) {
		System.out.println(ERROR_MESSAGE + e);
	}

	public static void printResult() {
		System.out.println(RESULT_FRONT_MESSAGE);
	}

	public static void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + ROUND_REGEX + POSITION_SIGNATURE.repeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinner(List<String> winner) {
		StringBuilder Result = new StringBuilder();
		for (String w : winner) {
			Result.append(w).append(WINNER_REGEX);
		}
		System.out.println(Result.substring(0, Result.length() - 2) + WINNER_RESULT_LAST_MESSAGE);
	}
}
