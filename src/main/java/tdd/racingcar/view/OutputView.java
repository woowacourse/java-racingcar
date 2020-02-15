package tdd.racingcar.view;

public class OutputView {
	public static void printResultMessage() {
		System.out.println("실행 결과");
	}

	public static void printRecord(String record) {
		System.out.println(record);
	}

	public static void printWinners(String winners) {
		System.out.println(winners + "가 최종 우승했습니다.");
	}
}
