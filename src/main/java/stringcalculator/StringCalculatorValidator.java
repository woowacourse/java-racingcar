package stringcalculator;

public class StringCalculatorValidator {
	public static final String INVALID_NUMBER = "[ERROR] 올바른 숫자 입력이 아닙니다";

	public static void isValidNumbers(String[] inputNumbers) {
		for (String inputNumber : inputNumbers) {
			isNumber(inputNumber);
			isNotNegativeNumber(inputNumber);
		}
	}

	private static void isNotNegativeNumber(String inputNumber) {
		int number = Integer.parseInt(inputNumber);
		if (number < 0) {
			throw new RuntimeException(INVALID_NUMBER);
		}
	}

	private static void isNumber(String inputNumber) {
		try {
			Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			throw new RuntimeException(INVALID_NUMBER);
		}
	}
}
