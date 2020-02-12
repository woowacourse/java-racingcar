package com.woowacourse.racingGame.domain;

import java.util.Objects;

public class Position {
	private static final int ZERO_NUMBER = 0;
	private static final int MOVING_UNIT = 1;

	public static final Position ZERO = new Position(ZERO_NUMBER);

	private final int position;

	public Position(final int position) {
		checkValidation(position);
		this.position = position;
	}

	private void checkValidation(final int position) {
		if (position < ZERO_NUMBER) {
			throw new IllegalArgumentException("위치가 음수가 될 수 없습니다.");
		}
	}

	public Position increaseOne() {
		return new Position(position + MOVING_UNIT);
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return this.position == position.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
