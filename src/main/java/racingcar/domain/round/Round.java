package racingcar.domain.round;

import racingcar.exception.NotNumericException;
import racingcar.exception.NumberTooSmallException;

public class Round {

	private static final int MIN_NUMBER = 1;

	private int round;

	public Round(String round) {
		this(parseInt(round));
	}

	public Round(int round) {
		if (round < MIN_NUMBER) {
			throw new NumberTooSmallException("1 이상의 양수를 입력하세요.");
		}
		this.round = round;
	}

	private static int parseInt(String round) {
		try {
			return Integer.parseInt(round);
		} catch(NumberFormatException e) {
			throw new NotNumericException("1 이상의 양수를 입력하세요.");
		}
	}

	public boolean isSame(int number) {
		return round == number;
	}

	public void decrease() {
		this.round--;
	}
}
