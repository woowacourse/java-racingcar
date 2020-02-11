package calculator;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 *
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class CalculatorApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		InputView inputView = new InputView(scanner);

		String input = inputView.inputMathmeticalExpression();
		System.out.println(input);

		try {
			List<Integer> numbers = Calculator.splitByDelimiter(input);
			int result = Calculator.calculate(numbers);
			OutputView.printCalculateResult(result);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
		}
	}
}
