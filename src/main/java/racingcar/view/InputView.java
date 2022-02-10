package racingcar.view;

import java.util.Scanner;

import racingcar.util.StringConst;

public class InputView {
	public static String[] getCarNameInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().split(StringConst.DELIMITER.getValue());
	}

	public static int getTurnInput() {
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.nextLine());
	}
}
