package racingcar.view;

import java.util.HashMap;

import racingcar.util.StringConst;

public class OutputView {
	public static void askCarName() {
		System.out.println(StringConst.INPUT_CAR_NAME_MESSAGE.getValue());
	}

	public static void askTurn() {
		System.out.println(StringConst.INPUT_TURN_MESSAGE.getValue());
	}

	public static void displayCarPosition(HashMap<String, String> carPositions) {
		for (String eachCarName : carPositions.keySet()) {
			System.out.println(eachCarName + StringConst.OUTPUT_DELIMITER.getValue() + carPositions.get(eachCarName));
		}
	}
}
