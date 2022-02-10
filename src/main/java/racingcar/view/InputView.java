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
		if (flagStr.contains("[ERROR]")) {
			System.out.println(flagStr);
			return new String[] {"[ERROR]"};
		}
		return flagStr.split(StringConst.DELIMITER.getValue());
	}

	public static String getTurnInput() {
		Scanner scanner = new Scanner(System.in);
		String turn = scanner.nextLine();
		Checker checker = new Checker();
		String flagStr = checker.checkTurnConditions(turn);
		if (flagStr.contains("[ERROR]")) {
			System.out.println(flagStr);
			return "-1";
		}
		return flagStr;
	}
}
