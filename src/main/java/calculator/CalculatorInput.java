package calculator;

public class CalculatorInput {
	private final String INPUT_MESSAGE = "입력: ";

	public String userInput() {
		System.out.print(INPUT_MESSAGE);
		String stringInput = CalculatorMain.sc.nextLine();
		if(stringInput.contains("//")){
			return stringInput + '\n' + CalculatorMain.sc.nextLine();
		}
		return stringInput;
	}
}
