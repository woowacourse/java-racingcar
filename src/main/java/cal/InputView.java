package cal;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String expressionPattern = "^(-?[0-9]+)(\\s(\\+|-|\\*|/)\\s(-?[0-9]+))+$";

	public static String inputExpression() {
		try {
			System.out.println("식을 입력하세요 : ");
			return checkExpression(scanner.nextLine());
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			return inputExpression();
		}
	}

	static String checkExpression(String expression) {
		if(!expression.matches(expressionPattern)){
			throw new IllegalArgumentException("잘못 된 식입니다.");
		}
		return expression;
	}
}
