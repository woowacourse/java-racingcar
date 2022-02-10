package racingcar.view;

import racingcar.util.StringConst;

public class OutputView {
	public static void askCarName() {
		System.out.println(StringConst.INPUT_CAR_NAME_MESSAGE.getValue());
	}

	public static void askTurn() {
		System.out.println(StringConst.INPUT_TURN_MESSAGE.getValue());
	}
}
