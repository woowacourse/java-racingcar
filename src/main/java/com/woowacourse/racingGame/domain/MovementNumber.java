package com.woowacourse.racingGame.domain;

public class MovementNumber {
	private static final int ZERO = 0;

	private final int movementNumber;

	public MovementNumber(final String inputMovementNumber) {
		final int parsedNumber = checkValid(inputMovementNumber);
		checkPositive(parsedNumber);
		this.movementNumber = parsedNumber;
	}

	private int checkValid(final String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력한 이동 횟수가 숫자가 아닙니다.");
		}
	}

	private void checkPositive(final int parsedNumber) {
		if (parsedNumber <= ZERO) {
			throw new IllegalArgumentException("입력한 이동 횟수가 0보다 작은 값입니다.");
		}
	}

	public int getMovementNumber() {
		return this.movementNumber;
	}
}
