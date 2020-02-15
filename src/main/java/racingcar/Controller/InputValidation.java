package racingcar.Controller;

import racingcar.Util.StringUtils;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.InputMismatchException;
import java.util.List;

/**
 * 클래스 이름 : InputValidation.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class InputValidation {
	public static int validateInputTrialTime(final String trialTimeInput) {
		try {
			InputValidation.checkDecimalNumber(trialTimeInput);
			InputValidation.checkNotNumber(trialTimeInput);
			InputValidation.checkNegativeAndZeroInput(trialTimeInput);
			InputValidation.checkIntegerOverflow(trialTimeInput);
			return Integer.parseInt(trialTimeInput);
		} catch (Exception e) {
			OutputView.printExceptionMessage(e.getMessage());
		}
		return InputView.inputTrialTime();
	}

	public static void checkNegativeAndZeroInput(final String trialTime) {
		double value = Double.parseDouble(trialTime);
		if (value <= 0) {
			throw new IllegalArgumentException("음수 또는 0을 입력할 수 없습니다.");
		}
	}

	public static void checkIntegerOverflow(final String trialTime) {
		double value = Double.parseDouble(trialTime);
		if (value > Integer.MAX_VALUE) {
			throw new ArithmeticException("입력 범위를 초과했습니다.");
		}
	}

	public static void checkDecimalNumber(final String trialTime) {
		if (trialTime.contains(".")) {
			throw new InputMismatchException("소수는 입력할 수 없습니다.");
		}
	}

	public static void checkNotNumber(final String trialTime) {
		try {
			double value = Double.parseDouble(trialTime);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("문자는 입력할 수 없습니다.");
		}
	}
}
