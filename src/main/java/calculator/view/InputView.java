package calculator.view;

import java.util.Objects;
import java.util.Scanner;

/**
 * 입력 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class InputView {
	public static final String INPUT_MATHEMATICAL_EXPRESSION_GUIDE_MESSAGE = "수식을 입력하세요";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = Objects.requireNonNull(scanner);
	}

	public String inputMathemeticalExpression() {
		System.out.println(INPUT_MATHEMATICAL_EXPRESSION_GUIDE_MESSAGE);
		return scanner.useDelimiter("\n\n").next();
	}
}
