package racingcar;

public class OutputView {
	private static final String GAME_RESULT_TITLE = "\n실행 결과";
	private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
	private static final String POSITION_CHARACTOR = "-";
	private static final String CAR_POSITION_FORMAT = "%s : %s\n";

	public static void printGameResultTitle() {
		System.out.println(GAME_RESULT_TITLE);
	}

	public static void printCarPosition(CarDto car) {
		System.out.printf(
			CAR_POSITION_FORMAT, car.getName(), POSITION_CHARACTOR.repeat(car.getPosition()));
	}

	public static void printBlankLine() {
		System.out.println();
	}

	public static void printWinner(String winnerNames) {
		System.out.printf(WINNER_FORMAT, winnerNames);
	}
}
