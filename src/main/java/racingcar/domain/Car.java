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
	public static final int MINIMUM_NUMBER_TO_GO = 4;

	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = 0;
	}

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public void run(int randomNumber) {
		if (randomNumber >= MINIMUM_NUMBER_TO_GO) {
			position++;
		}
	}

	public boolean isPosition(int position) {
		return this.position == position;
	}

	public Car getBiggerCar(Car carB) {
		if (position >= carB.position) {
			return this;
		}
		return carB;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position &&
			Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	public boolean isSamePosition(Car maxPositionCar) {
		return position == maxPositionCar.position;
	}
}
