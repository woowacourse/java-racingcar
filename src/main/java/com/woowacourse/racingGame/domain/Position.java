package com.woowacourse.racingGame.domain;

import java.util.HashMap;
import java.util.Map;

public class Position {
	private static final int INIT_POSITION = 0;
	private static final int MOVING_UNIT = 1;
	private static final Map<Integer, Position> cache = new HashMap<>();
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

	public static Position valueOf(final int position) {
		if (cache.containsKey(position)) {
			return cache.get(position);
		}
		Position newPosition = new Position(position);
		cache.put(position, newPosition);
		return newPosition;
	}

	public Position increaseByMovingUnit() {
		return Position.valueOf(position + MOVING_UNIT);
	}

	public int getPosition() {
		return position;
	}
}
