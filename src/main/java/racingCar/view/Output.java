package racingCar.view;

import java.util.List;

import racingCar.model.RacingCars;

public class Output {
	private static final String RESULT_FRONT_MESSAGE = "\n실행 결과";
	private static final String WINNER_REGEX = ", ";
	private static final String WINNER_RESULT_LAST_MESSAGE = "가 최종 우승했습니다.";

	public static void printStartMessage() {
		System.out.println(RESULT_FRONT_MESSAGE);
	}

	public static void printRoundResult(String result) {
		System.out.println(result);
	}

	public static void printWinner(List<String> winner) {
		StringBuilder Result = new StringBuilder();
		for (String w : winner) {
			Result.append(w).append(WINNER_REGEX);
		}
		System.out.println(Result.substring(0, Result.length() - 2) + WINNER_RESULT_LAST_MESSAGE);
	}
}