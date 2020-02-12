package racingcar.io;

import java.util.Scanner;

import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.domain.factory.CarsFactory;

public class InputView {
	public static final String SEPARATOR = ",";
	private static final Scanner scanner = new Scanner(System.in);

	public static Cars getCars() {
		System.out.println("이름을 입력하세요");
		try {
			String[] names = InputView.getNames();
			return CarsFactory.create(names);
		} catch (Exception e) {
			return getCars();
		}
	}

	public static Times getTimes() {
		System.out.println("수행 할 횟수를 입력하세요.");
		try {
			return new Times(InputView.getInput());
		} catch (Exception e) {
			return getTimes();
		}
	}

	private static String getInput() {
		return scanner.nextLine();
	}

	private static String[] getNames() {
		return getInput().split(SEPARATOR);
	}
}
