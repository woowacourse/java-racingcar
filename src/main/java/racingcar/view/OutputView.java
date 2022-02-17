package racingcar.view;

import java.util.List;

public class OutputView {
	public static void askCarName() {
		System.out.println(StringConst.INPUT_CAR_NAME_MESSAGE.getValue());
	}

	public static void askTurn() {
		System.out.println(StringConst.INPUT_TURN_MESSAGE.getValue());
	}

	public static void displayCarPosition(List<String> nameList, List<Integer> positionList,
										  String delimiter) {
		int totalSize = nameList.size();
		for (int index = 0; index < totalSize; index++) {
			System.out.println(nameList.get(index) + StringConst.OUTPUT_DELIMITER.getValue() + delimiter.repeat(
				positionList.get(index)));
		}
		System.out.println();
	}

	public static void displayWinner(List<String> winnerName) {
		System.out.println(
			String.join(StringConst.WINNER_DELIMITER.getValue(), winnerName) + StringConst.WINNER_MESSAGE.getValue());
	}

	public static void displayResult() {
		System.out.println(StringConst.RESULT_MESSAGE.getValue());
	}

	public static void displayError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
