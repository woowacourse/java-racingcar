package racingcar.View;

import java.util.InputMismatchException;
import java.util.Scanner;

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
	private static final String INPUT_RANGE_EXCEPTION_MESSAGE = "1~100 범위의 양의 정수만 입력해주세요.";

	private static Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static String inputCarName() {
		OutputView.printInputCarNamesMessage();
		return SCANNER.nextLine();
	}

	public static int inputTrialTime() {
		try {
			OutputView.printInputTrialTimeMessage();
			return SCANNER.nextInt();
		} catch (InputMismatchException e) {
			throw new InputMismatchException(INPUT_RANGE_EXCEPTION_MESSAGE);
		}

	}
}
