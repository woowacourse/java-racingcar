package racingcar.view;

import java.util.List;

public class OutputView {
	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_TURN_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String OUTPUT_DELIMITER = " : ";
	private static final String WINNER_DELIMITER = ", ";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String POSITION_DELIMITER = "-";

	public static void askCarName() {
		System.out.println(INPUT_CAR_NAME_MESSAGE);
	}

	public static void askTurn() {
		System.out.println(INPUT_TURN_MESSAGE);
	}

	public static void displayCarPosition(List<String> nameList, List<Integer> positionList) {
		int totalSize = nameList.size();
		for (int index = 0; index < totalSize; index++) {
			System.out.println(nameList.get(index) + OUTPUT_DELIMITER + POSITION_DELIMITER.repeat(
				positionList.get(index)));
		}
		System.out.println();
	}

	public static void displayWinner(List<String> winnerName) {
		System.out.println(
			String.join(WINNER_DELIMITER, winnerName) + WINNER_MESSAGE);
	}

	public static void displayResult() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void displayError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
