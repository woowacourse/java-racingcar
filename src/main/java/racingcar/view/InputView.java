package racingcar.view;

import java.util.Scanner;

import racingcar.util.Checker;
import racingcar.util.StringConst;

public class InputView {
	public static String[] getCarNameInput() {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		Checker checker = new Checker();
		String flagStr = checker.checkNameConditions(name);
		return checkNameError(flagStr);
	}

	private static String[] checkNameError(String str) {
		if (str.contains(StringConst.ERROR_PREFIX.getValue())) {
			System.out.println(str);
			return new String[] {StringConst.ERROR_PREFIX.getValue()};
		}
		return str.split(StringConst.DELIMITER.getValue());
	}

	public static String getTurnInput() {
		Scanner scanner = new Scanner(System.in);
		String turn = scanner.nextLine();
		Checker checker = new Checker();
		String flagStr = checker.checkTurnConditions(turn);
		return checkTurnError(flagStr);
	}

	private static String checkTurnError(String str) {
		if (str.contains(StringConst.ERROR_PREFIX.getValue())) {
			System.out.println(str);
			return StringConst.ERROR_TURN_FLAG.getValue();
		}
		return str;
	}
}
