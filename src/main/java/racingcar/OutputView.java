package racingcar;

public class OutputView {
	private static final String GAME_RESULT_TITLE = "\n실행 결과";
	private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";

	public static void printGameResultTitle() {
		System.out.println(GAME_RESULT_TITLE);
	}

	public static void printLineString(String string) {
		System.out.println(string);
	}

	public static void printBlankLine() {
		System.out.println();
	}

	public static void printWinner(String winnerNames) {
		System.out.printf(WINNER_FORMAT, winnerNames);
	}
}
