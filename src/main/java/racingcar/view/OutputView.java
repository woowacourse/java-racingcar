package racingcar.view;

import java.util.List;

public class OutputView {

	public static final String RESULT_SENTENCE_MESSAGE = "\n실행 결과";
	public static final String COMMA_DELIMITER = ", ";
	public static final String ANNOUNCE_WINNERS = "가 최종 우승했습니다.";

	public void printResultSentence() {
		System.out.println(RESULT_SENTENCE_MESSAGE);
	}

	public void printResult(List<String> results) {
		results.stream()
			.forEach(System.out::println);
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		System.out.print(String.join(COMMA_DELIMITER, winners));
		System.out.println(ANNOUNCE_WINNERS);
	}
}
