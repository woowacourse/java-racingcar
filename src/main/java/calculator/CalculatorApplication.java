package calculator;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

import calculator.domain.Expression;
import calculator.domain.Operand;
import calculator.domain.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 프로그램 실행 클래스
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

		String input = inputView.inputMathemeticalExpression();
		System.out.println(input);

		try {
			List<Operand> numbers = StringSplitter.splitByDelimiter(input);
			Expression expression = new Expression(numbers);
			Operand result = expression.calculate();
			OutputView.printCalculateResult(result);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
		}
	}
}
