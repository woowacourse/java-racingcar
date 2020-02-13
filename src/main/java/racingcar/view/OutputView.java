package racingcar.view;

public class OutputView {
	public static void printExceptionMessage(Exception e) {
		e.printStackTrace();
	}

	public static void printCurrentPosition(String currentPosition) {
		System.out.println(currentPosition);
	}
}
