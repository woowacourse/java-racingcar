package com.woowacourse.racingGame.domain;

import java.util.Objects;

public class Position {
	private static final int INIT_POSITION = 0;
	private static final int MOVING_UNIT = 1;

	public static final Position ZERO = new Position(INIT_POSITION);

	private final int position;

	public Position(final int position) {
		checkValid(position);
		this.position = position;
	}

	private void checkValid(final int position) {
		if (position < INIT_POSITION) {
			throw new IllegalArgumentException("위치가 음수가 될 수 없습니다.");
		}
	}

	public Position increaseByMovingUnit() {
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
