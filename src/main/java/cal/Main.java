package cal;

public class Main {
	static final Calculator cal = new Calculator();;

	public static void main(String[] args) {
		try {
			String input = InputView.inputExpression();
			int result = cal.execute(input);
			OutputView.printResult(result);
		} catch (ArithmeticException e) {
			System.out.println("계산이 불가능합니다. 다시 입력해주세요!");
			main(null);
		}
	}
}
