package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
	private static final String STRING_JOIN_DELIMITER = " : ";
	private static final String MOVE_EXPRESSION = "-";
	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	public static final String WINNER_JOIN_DELIMITER = ", ";

	public static void printCarPosition(Map<String, Integer> cars) {
		StringBuilder outputString = new StringBuilder();
		cars.keySet().forEach(name -> outputString.append(name)
			.append(STRING_JOIN_DELIMITER)
			.append(MOVE_EXPRESSION.repeat(cars.get(name)))
			.append('\n'));
		System.out.println(outputString);
	}

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printWinners(List<String> winners) {
		System.out.println(winners.stream()
			.collect(Collectors.joining(WINNER_JOIN_DELIMITER))
			+ WINNER_MESSAGE
		);
	}
}
