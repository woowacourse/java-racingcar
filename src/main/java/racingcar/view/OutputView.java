package racingcar.view;

public class OutputView {
	public static void printException(Exception exception) {
		System.out.println(exception.getMessage());
	}

	public static void printStartMessage() {
		System.out.println("실행 결과");
	}

	public static void printString(String string) {
		System.out.println(string);
	}
}
