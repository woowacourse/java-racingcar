package calculator.view;

/**
 *
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class OutputView {
	public static final String CALCULATOR_RESULT_MESSAGE_FORMAT = "연산 결과는 %d 입니다.\n";

	private OutputView() {
	}

	public static void printCalculateResult(final int result) {
		System.out.printf(CALCULATOR_RESULT_MESSAGE_FORMAT, result);
	}

	public static void printExceptionMessage(final String message) {
		System.out.println(message);
	}
}
