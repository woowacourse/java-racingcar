package racingcar.View;

import java.util.List;
import java.util.Scanner;

import racingcar.Controller.InputValidation;

/**
 * 클래스 이름 : InputView.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static List<String> inputCarName() {
		OutputView.printInputCarNamesMessage();
		return InputValidation.validateInputCarName(scanner.nextLine());
	}

	public static int inputTrialTime() {
		OutputView.printInputTrialTimeMessage();
		String trialTime = scanner.nextLine();
		try {
			InputValidation.checkDecimalNumber(trialTime);
			InputValidation.checkNotNumber(trialTime);
			InputValidation.checkNegativeAndZeroInput(trialTime);
			InputValidation.checkIntegerOverflow(trialTime);
			return Integer.parseInt(trialTime);
		} catch (Exception e) {
			OutputView.printExceptionMessage(e);
		}
		return inputTrialTime();
	}
}
