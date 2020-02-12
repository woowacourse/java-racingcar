package com.woowacourse.racingGame.domain;

public class Position {
	public static final int ZERO = 0;

	private final int position;

	public Position(final int position) {
		checkValidation(position);
		this.position = position;
	}

	private void checkValidation(final int position) {
		if (position < ZERO) {
			throw new IllegalArgumentException("위치가 음수가 될 수 없습니다.");
		}
	}
}
