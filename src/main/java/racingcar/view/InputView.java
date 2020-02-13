package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static String getCarNames() {
		System.out.println("쉼표(',') 기준으로 자동차 이름을 입력하세요(이름 중복 불가)");
		return scanner.nextLine();
	}

	public static String getPlayRound() {
		System.out.println("시도할 횟수를 입력하세요");
		return scanner.nextLine();
	}

}
