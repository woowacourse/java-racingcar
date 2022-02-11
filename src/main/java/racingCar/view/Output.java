package racingCar.view;

import java.util.List;

import racingCar.model.Car;
import racingCar.utlis.Constants;

public class Output {

	public static void printError(String e) {
		System.out.println(Constants.ERROR_MESSAGE + e);
	}

	public static void printResult() {
		System.out.println(Constants.RESULT_FRONT_MESSAGE);
	}

	public static void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + Constants.ROUND_REGEX + Constants.POSITION_SIGNATURE.repeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinner(List<String> winner) {
		StringBuilder Result = new StringBuilder();
		for (String w : winner) {
			Result.append(w).append(Constants.WINNER_REGEX);
		}
		System.out.println(Result.substring(0, Result.length() - 2) + Constants.WINNER_RESULT_LAST_MESSAGE);
	}
}
