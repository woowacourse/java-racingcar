package racingcargame.domain;

import racingcargame.exception.InvalidTryNumberException;
import racingcargame.view.OutputView;

public class TryNumber {
	private static final int MIN_TRY_NUMBER = 1;

	private final int number;

	public TryNumber(String inputNumber) {
		int number = getNumber(inputNumber);
		checkUnderMinTryNumber(number);
		this.number = number;
	}

	private int getNumber(String inputNumber) {
		int number;
		try {
			number = Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			OutputView.printNotNumberFormatErrorMessage();
			throw new NumberFormatException("※시도 회수는 정수만 입력 가능");
		}
		return number;
	}

	private void checkUnderMinTryNumber(int number) {
		if (number < MIN_TRY_NUMBER) {
			OutputView.printInvalidTryNumberErrorMessage();
			throw new InvalidTryNumberException("※시도 회수는 1 이상의 숫자만 입력 가능");
		}
	}

	public boolean isBiggerThan(int number) {
		return number < this.number;
	}
}
