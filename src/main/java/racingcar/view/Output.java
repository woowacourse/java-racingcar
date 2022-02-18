package racingcar.view;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.RacingCar;

public class Output {

	private static final String ERROR_MSG = "[ERROR]";
	private static final String POSITION_SIGNATURE = "-";
	private static final String RESULT_MSG = "\n실행 결과";
	private static final String NAME_AND_POSITION_CONNECTION = " : ";
	private static final String WINNER_SEPARATED_STR = ", ";
	private static final int START_STRING_INDEX = 0;
	private static final String FINAL_WINNER_MSG = "가 최종 우승했습니다.";
	private static final int FINAL_RESULT_STRING_MINUS_INDEX = 2;

	public static void printError(String error) {
		System.out.println(ERROR_MSG + error);
	}

	public static void printResultMessage() {
		System.out.println(RESULT_MSG);
	}

	public static void printRoundResult(List<RacingCar> cars) {
		for (RacingCar car : cars) {
			System.out.println(
				car.getName().getName() + NAME_AND_POSITION_CONNECTION + POSITION_SIGNATURE.repeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinners(List<Name> winners) {
		StringBuilder result = new StringBuilder();
		winners.forEach(
			winner -> result.append(winner.getName()).append(WINNER_SEPARATED_STR)
		);
		System.out.println(result.substring(START_STRING_INDEX, result.length() - FINAL_RESULT_STRING_MINUS_INDEX) + FINAL_WINNER_MSG);
	}
}
