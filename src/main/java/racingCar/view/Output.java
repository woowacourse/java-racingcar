package racingCar.view;

import java.util.List;

import racingCar.model.RacingCars;
import racingCar.utlis.Constants;

public class Output {

	public static void printError(String e) {
		System.out.println(Constants.ERROR_MESSAGE + e);
	}

	public static void printStartMessage() {
		System.out.println(Constants.RESULT_FRONT_MESSAGE);
	}

	public static void printRoundResult(RacingCars cars) {
		System.out.println(cars.getRoundResult() + "\n");
	}

	public static void printWinner(List<String> winner) {
		StringBuilder Result = new StringBuilder();
		for (String w : winner) {
			Result.append(w).append(Constants.WINNER_REGEX);
		}
		System.out.println(Result.substring(0, Result.length() - 2) + Constants.WINNER_RESULT_LAST_MESSAGE);
	}
}
