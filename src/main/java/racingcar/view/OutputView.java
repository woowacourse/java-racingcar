package racingcar.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class OutputView {

	private static final String MESSAGE_ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String MESSAGE_ASK_TURN = "시도할 회수는 몇회인가요?";
	private static final String MESSAGE_SHOW_RESULT = "실행 결과";
	private static final String RESULT_DELIMITER = " : ";
	private static final String WINNER_DELIMITER = ", ";
	private static final String POSITION_SYMBOL = "-";
	private static final String MESSAGE_WIN = "가 최종 우승했습니다.";

	public static void askCarName() {
		System.out.println(MESSAGE_ASK_CAR_NAME);
	}

	public static void askTurn() {
		System.out.println(MESSAGE_ASK_TURN);
	}

	public static void printResultMessage() {
		System.out.println(MESSAGE_SHOW_RESULT);
	}

	public static void printCarPosition(LinkedHashMap<String, Integer> carInfo) {
		for (String eachCarName : carInfo.keySet()) {
			System.out.println(eachCarName + RESULT_DELIMITER + POSITION_SYMBOL.repeat(carInfo.get(eachCarName)));
		}
		System.out.println();
	}

	public static void printWinner(ArrayList<String> winners) {
		System.out.println(
			String.join(WINNER_DELIMITER, winners) + MESSAGE_WIN);
	}
}