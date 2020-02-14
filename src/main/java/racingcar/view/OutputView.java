package racingcar.view;

public class OutputView {
	private static final String NEW_LINE = System.lineSeparator();

	public static void printExceptionMessage(String message) {
		System.out.println(message);;
	}

	public static void printCurrentPosition(String currentPosition) {
		System.out.println(currentPosition + NEW_LINE);
	}

	public static void printRaceStart() {
		System.out.println(NEW_LINE + "레이스 시작!!!!!!");
	}

	public static void printWinnersName(String winnersName) {
		System.out.println(winnersName + " 우승!!!!!!!!");
	}
}
