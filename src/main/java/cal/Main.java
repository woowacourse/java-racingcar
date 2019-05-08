package cal;

public class Main {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		String input = InputView.inputExpression();
		int result = cal.execute(input);
		OutputView.printResult(result);
	}
}
