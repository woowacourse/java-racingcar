package calculator.validator;

import java.util.Arrays;

public class Validator {
	private static final String REGULAR_EXPRESSION_OF_OPERATOR = "[+|\\-|*|/]";
	private static final String REGULAR_EXPRESSION_OF_NUMBER = "[1-9][0-9]*";

	public static boolean validateAll(String value) {
		String[] values = value.split(" ");

		if (!validateLength(values)) {
			System.out.println("계산식을 잘못 입력하였습니다. 다시 입력해주세요!");
			return false;
		}
		if (!validateForm(values)) {
			System.out.println("숫자와 연산자 외의 다른 문자를 입력하였습니다! 다시 입력해주세요!");
			return false;
		}
		if (!dividedZero(value)) {
			System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요!");
			return false;
		}
		if (!validateOrder(values)) {
			System.out.println("계산식의 순서가 올바르지 않습니다. 다시 입력해주세요!");
			return false;
		}
		return true;
	}

	private static boolean validateLength(String[] values) {
		return (values.length < 3) ? false : true;
	}

	private static boolean validateForm(String[] values) {
		return !(Arrays.stream(values).anyMatch(x -> !(x.matches(REGULAR_EXPRESSION_OF_NUMBER)) && !(x.matches(REGULAR_EXPRESSION_OF_OPERATOR))));
	}

	private static boolean dividedZero(String value) {
		return !(value.contains("/ 0"));
	}

	private static boolean validateOrder(String[] values) {
		int wrongCount = 0;

		for (int i = 0; i < values.length; ++i) {
			if (i % 2 == 0) {
				wrongCount += (values[i].matches(REGULAR_EXPRESSION_OF_NUMBER)) ? 0 : 1;
			} else {
				wrongCount += (values[i].matches(REGULAR_EXPRESSION_OF_OPERATOR)) ? 0 : 1;
			}
		}
		return (wrongCount > 0) ? false : true;
	}

}
