package racingcar.view;

import racingcar.dto.CarDto;

public class OutputView {
	private static final String GAME_RESULT_TITLE = "\n실행 결과";
	private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
	private static final String TO_STRING_CONJUNCTION = " : ";
	private static final String POSITION_CHARACTOR = "-";

	public static void printGameResultTitle() {
		System.out.println(GAME_RESULT_TITLE);
	}

	public static void printLineString(CarDto carDto) {
		System.out.println(carDto.getName() + TO_STRING_CONJUNCTION+ buildStringPosition(carDto.getPosition()));
	}

	private static String buildStringPosition(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append(POSITION_CHARACTOR);
		}
		return stringBuilder.toString();
	}

	public static void printBlankLine() {
		System.out.println();
	}

	public static void printWinner(String winnerNames) {
		System.out.printf(WINNER_FORMAT, winnerNames);
	}
}
