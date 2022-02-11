package racingcar;

public class OutputView {
	private static final String GAME_RESULT_TITLE = "\n실행 결과";

	public static void printGameResultTitle() {
		System.out.println(GAME_RESULT_TITLE);
	}

	public static void printLineString(String string) {
		System.out.println(string);
	}

	public static void printBlankLine() {
		System.out.println();
	}
}
