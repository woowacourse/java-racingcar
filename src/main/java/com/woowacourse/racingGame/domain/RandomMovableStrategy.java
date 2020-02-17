package com.woowacourse.racingGame.domain;

public class RandomMovableStrategy implements MovableStrategy {

	@Override
	public boolean isMovable() {
		Power power = PowerGenerator.generateRandomNumber();
		return power.isMovable();
	}
}
