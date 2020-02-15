package calculator.view;

import calculator.domain.Operand;

public class OutputView {
	private OutputView() {
	}

	public static void printResult(Operand result) {
		System.out.println("결과 : " + result.getNumber());
	}
}
