package calculator;

public class CalculatorInput {
	private static final String CUSTOM_SEPARATOR_START_SIGNATURE = "//";
	private final String INPUT_MESSAGE = "입력: ";

	public String userInput() {
		System.out.print(INPUT_MESSAGE);
		String stringInput = CalculatorMain.sc.nextLine();
		if (stringInput.contains(CUSTOM_SEPARATOR_START_SIGNATURE)) {
			return stringInput + '\n' + CalculatorMain.sc.nextLine();
		}
		return stringInput;
	}
}
