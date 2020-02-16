package racingcar.domain;

import java.util.Objects;

import racingcar.message.RacingCarMessage;

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

	private int position;

	public Position(int position) {
		validatePositionRange(position);
		this.position = position;
	}

	private void validatePositionRange(int position) {
		if (position < MIN_POSITION_VALUE) {
			throw new IllegalArgumentException(RacingCarMessage.ILLEGAL_CAR_POSITION.getMessageText());
		}
	}

	public void moveForward() {
		position += MOVING_DISTANCE;
	}

	public boolean isGreaterThanOrEqualTo(Position otherPosition) {
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
