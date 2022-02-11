package racingcar.view;

import java.util.List;

public class OutputView {

	private static String RACING_RESULT_MESSAGE = "실행 결과";

	public static void printResultMessage() {
		System.out.println(RACING_RESULT_MESSAGE);
	}

	public static void printRacingRecords(List<String> racingRecords) {
		for (int i = 0 ; i < racingRecords.size() ; i++) {
			System.out.println(racingRecords.get(i));
		}
		System.out.println();
	}

	public static void printWinnerNames(List<String> winnerNames) {
		String winners = String.join(", ", winnerNames);
		System.out.println(winners + "가 최종 우승했습니다.");
	}
}
