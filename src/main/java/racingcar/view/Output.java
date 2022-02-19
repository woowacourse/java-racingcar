package racingcar.view;

import java.util.List;

public class Output {
	private static final String STEP = "-";

	public static void errorMessage(String message) {
		System.out.println("[ERROR] " + message);
	}

	public static void getCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void getAttempt() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void resultTitle() {
		newLine();
		System.out.println("실행 결과");
	}

	public static void roundResult(String name, int position) {
		System.out.println(name + " : " + STEP.repeat(position));
	}

	public static void newLine() {
		System.out.println();
	}

	public static void showResult(List<String> winners) {
		System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
	}
}
