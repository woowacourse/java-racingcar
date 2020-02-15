package racingcargame.view;

import java.util.Scanner;

class InputView {

	private static Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	static String inputNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.nextLine();
	}

	static String inputRepeat() {
		System.out.println("시도할 회수는 몇회인가요?");
		return scanner.nextLine();
	}
}