package racingcar.domain;

import java.util.Objects;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Car.java
 * 자동차 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class Car {
	private final Name name;
	private final Position position;

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		this.name = new Name(name);
		this.position = new Position(position);
	}

	public void move(Power power) {
		if (power.isMovable()) {
			position.moveForward();
		}
	}

	Car getFartherCar(Car otherCar) {
		if (position.isGreaterThanOrEqualTo(otherCar.position)) {
			return this;
		}
		return otherCar;
	}

	boolean isSamePosition(Car otherCar) {
		return position.equals(otherCar.position);
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
		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
