package com.woowacourse.racingGame.domain;

import java.util.Objects;

public class Car {
	private final MovableStrategy movableStrategy;
	private final Name name;
	private Position position;

	public Car(Name name, MovableStrategy movableStrategy) {
		this.position = Position.ZERO;
		this.name = name;
		this.movableStrategy = movableStrategy;
	}

	Car(Name name, Position position, MovableStrategy movableStrategy) {
		this.position = position;
		this.name = name;
		this.movableStrategy = movableStrategy;
	}

	public void attemptMoveThrough() {
		if (movableStrategy.isMovable()) {
			position = position.increaseByMovingUnit();
		}
	}

	// NOTE : 불변객체의 이점?
	public boolean isSamePosition(final int winnerPosition) {
		return position.getPosition() == winnerPosition;
	}

	public String getName() {
		return name.getName();
	}

	public int getPosition() {
		return position.getPosition();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
