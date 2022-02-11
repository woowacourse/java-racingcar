package calculator;

import java.util.Scanner;

public class CalculatorInput {
	private static final String CUSTOM_SEPARATOR_START_SIGNATURE = "//";
	private static final String INPUT_MESSAGE = "입력: ";

	public static Scanner scanner = new Scanner(System.in);

	public String userInput() {
		System.out.print(INPUT_MESSAGE);
		String stringInput = scanner.nextLine();
		if (stringInput.contains(CUSTOM_SEPARATOR_START_SIGNATURE)) {
			return stringInput + '\n' + scanner.nextLine();
		}
		return stringInput;
	}
}
