package com.woowacourse.racingGame.domain;

import java.util.Objects;

public class Car {
	private final Name name;
	private Position position;

	public Car(Name name) {
		this.position = Position.ZERO;
		this.name = name;
	}

	public Car(Name name, Position position) {
		this.position = position;
		this.name = name;
	}

	public void attemptMoveThrough(final RandomNo randomNo) {
		if (isMovable(randomNo)) {
			this.position = this.position.increaseByMovingUnit();
		}
	}

	private boolean isMovable(final RandomNo randomNo) {
		return randomNo.isMovable();
	}

	// NOTE : 불변객체의 이점?
	public boolean isSamePosition(final int winnerPosition) {
		return this.position.getPosition() == winnerPosition;
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
