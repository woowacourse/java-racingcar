package racingcar.view;

public class OutputView {
	public static void printExceptionMessage(Exception e) {
		e.printStackTrace();
	}

	public static void printCurrentPosition(String currentPosition) {
		System.out.println(currentPosition);
	}

	public static void printRaceStart() {
		System.out.println("레이스 시작!!!!!!");
	}
}
