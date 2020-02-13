package com.woowacourse.racingGame.domain;

import java.util.Objects;

public class Car {
	private static final int MOVE_BOUND = 4;

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

	public void move(final int randomNumber) {
		if (isMove(randomNumber)) {
			this.position = this.position.increaseOne();
		}
	}

	private boolean isMove(final int randomNumber) {
		return randomNumber >= MOVE_BOUND;
	}

	public boolean isWinnerPosition(final int winnerPosition) {
		return this.position.getPosition() == winnerPosition;
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}

	public void setPosition(final int position) {
		this.position = new Position(position);
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
