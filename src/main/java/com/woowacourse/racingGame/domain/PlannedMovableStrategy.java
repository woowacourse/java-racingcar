package com.woowacourse.racingGame.domain;

public class PlannedMovableStrategy implements MovableStrategy {
	private Power power;

	public PlannedMovableStrategy(final Power power) {
		this.power = power;
	}

	@Override
	public boolean isMovable() {
		return power.isMovable();
	}
}
