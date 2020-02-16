package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Position.java
 * 자동차 위치 관련 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        14 Feb 2020
 *
 */
public class Position {
	private static final int MIN_POSITION_VALUE = 0;
	private static final int MOVING_DISTANCE = 1;

	private static final String ILLEGAL_CAR_POSITION_EXCEPTION_MESSAGE = "position can not be negative";

	private static final int CACHE_MINIMUM = 0;
	private static final int CACHE_MAXIMUM = 256;
	private static final Map<Integer, Position> positionCache = new HashMap<>();

	static {
		initPositionCache();
	}

	private static void initPositionCache() {
		for (int i = CACHE_MINIMUM; i <= CACHE_MAXIMUM; i++) {
			positionCache.put(i, new Position(i));
		}
	}

	private final int position;

	private Position(int position) {
		validatePositionRange(position);
		this.position = position;
	}

	private void validatePositionRange(int position) {
		if (position < MIN_POSITION_VALUE) {
			throw new IllegalArgumentException(ILLEGAL_CAR_POSITION_EXCEPTION_MESSAGE);
		}
	}

	static Position ofValue(int position) {
		if (positionCache.containsKey(position)) {
			return positionCache.get(position);
		}
		return new Position(position);
	}

	Position moveForward() {
		return ofValue(position + MOVING_DISTANCE);
	}

	boolean isGreaterThanOrEqualTo(Position otherPosition) {
		return position >= otherPosition.position;
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
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
