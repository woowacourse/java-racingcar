package cal;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String expressionPattern = "^(-?[0-9]+)(\\s(\\+|-|\\*|/)\\s(-?[0-9]+))+$";

	public static String inputExpression() {
		System.out.println("식을 입력하세요 : ");
		return scanner.nextLine();
	}

	static boolean checkExpression(String expression) {
		return expression.matches(expressionPattern);
	}
}
