/*
 * Position.java                        1.0.0   2020-02-15
 *
 * Copyright (c) 2020 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package racingcar.domain;

/**
 * 자동차 포지션을 의미하는 객체입니다.
 *
 * @author HyungjuAn
 */
public class Position {
	private static final int MINIMUM_MOVE_VALUE = 4;

	private int position;

	public Position(int position) {
		this.position = position;
	}

	public void move() {
		position++;
	}

	public boolean isMovable(int value) {
		return value >= MINIMUM_MOVE_VALUE;
	}

	public int getPosition() {
		return position;
	}
}
