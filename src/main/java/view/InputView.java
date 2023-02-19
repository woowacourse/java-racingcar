package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public String askCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		try {
			return scanner.nextLine();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askCars();
		}
	}

	public int askTrial() {
		System.out.println("시도할 횟수는 몇회인가요?");
		try {
			int trial = scanner.nextInt();
			scanner.close();
			return trial;
		} catch (IllegalArgumentException e) {
			System.out.println("입력값은 숫자만 가능합니다.");
			return askTrial();
		}
	}
}
