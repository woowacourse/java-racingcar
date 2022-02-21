package racingcar.view;

import java.util.List;

import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.model.RacingCar;

public class Output {

	private static final String POSITION_SIGNATURE = "-";
	private static final String RESULT_MSG = "\n실행 결과";
	private static final String NAME_AND_POSITION_CONNECTION = " : ";
	private static final String WINNER_SEPARATED_STR = ", ";
	private static final int START_STRING_INDEX = 0;
	private static final String FINAL_WINNER_MSG = "가 최종 우승했습니다.";
	private static final int FINAL_RESULT_STRING_MINUS_INDEX = 2;


	public void printResultMessage() {
		System.out.println(RESULT_MSG);
	}

	public void printRoundResult(final List<Cars> gameResult) {
		printResultMessage();
		gameResult.forEach(this::printOneRoundResult);
	}

	private void printOneRoundResult(final Cars cars) {
		for (RacingCar car : cars.getCars()) {
			System.out.println(
				car.getName() + NAME_AND_POSITION_CONNECTION + POSITION_SIGNATURE.repeat(car.getPosition()));
		}
		System.out.println();
	}

	public void printWinners(final List<String> winners) {
		StringBuilder result = new StringBuilder();
		winners.forEach(
			winner -> result.append(winner).append(WINNER_SEPARATED_STR)
		);
		System.out.println(result.substring(START_STRING_INDEX, result.length() - FINAL_RESULT_STRING_MINUS_INDEX) + FINAL_WINNER_MSG);
	}
}
