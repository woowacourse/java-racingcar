package racingcar.view;

import java.util.List;

public class OutputView {

	private static final String COMMA = ", ";

	public static void showResult() {
		System.out.println("\n실행 결과");
	}

	public static void showRace(String raceResult) {
		System.out.println(raceResult);
	}

	public static void showWinner(List<String> winners) {
		System.out.print(String.join(COMMA, winners));
		System.out.println("가 최종 우승했습니다.");
	}
}
