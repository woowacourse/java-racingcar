package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

	private static final String RESULT_SENTENCE_MESSAGE = "\n실행 결과";
	private static final String COMMA_DELIMITER = ", ";
	private static final String ANNOUNCE_WINNERS = "가 최종 우승했습니다.";
	private static final String ONE_STEP = "-";
	private static final String COLON = " : ";

	public static void printResultSentence() {
		System.out.println(RESULT_SENTENCE_MESSAGE);
	}

	public static void printResult(Map<String, Integer> carPositions) {
		carPositions.forEach((name, position) -> System.out.println(name + COLON + ONE_STEP.repeat(position)));
		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		System.out.print(String.join(COMMA_DELIMITER, winners));
		System.out.println(ANNOUNCE_WINNERS);
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

}
