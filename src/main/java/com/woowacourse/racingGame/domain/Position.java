package com.woowacourse.racingGame.domain;

public class Position {
	private static final int INIT_POSITION = 0;
	private static final int MOVING_UNIT = 1;

	public static final Position ZERO = Position.valueOf(INIT_POSITION);

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

	public static Position valueOf(final int position) {
		if (position >= PositionCache.low && position <= PositionCache.high) {
			return PositionCache.cache[position + (-PositionCache.low)];
		}
		return new Position(position);
	}

	public Position increaseByMovingUnit() {
		return Position.valueOf(position + MOVING_UNIT);
	}

	public int getPosition() {
		return position;
	}
}
