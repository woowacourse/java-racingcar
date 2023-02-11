package view;

import java.util.Scanner;

import domain.Cars;
import domain.Trial;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public Cars askCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		try {
			return new Cars(scanner.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askCars();
		}
	}

	public Trial askTrial() {
		System.out.println("시도할 횟수는 몇회인가요?");
		try {
			Trial trial = new Trial(Integer.parseInt(scanner.nextLine()));
			scanner.close();
			return trial;
		} catch (NumberFormatException e) {
			System.out.println("숫자로만 입력해주세요");
			return askTrial();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askTrial();
		}
	}
}
