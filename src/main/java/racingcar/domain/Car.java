package racingcar.domain;

import racingcar.movingstrategy.MovingStrategy;
import racingcar.movingstrategy.RandomMovingStrategy;

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
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;
    private MovingStrategy movingStrategy;

    public Car(String name) {
        this(name, DEFAULT_POSITION, RandomMovingStrategy.getInstance());
    }

    Car(String name, int position, MovingStrategy movingStrategy) {
        this.name = name;
        this.position = position;
        this.movingStrategy = movingStrategy;
    }

    public void run() {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    Car getFartherCar(Car otherCar) {
        if (position >= otherCar.position) {
            return this;
        }
        return otherCar;
    }

    boolean isSamePosition(Car maxPositionCar) {
        return position == maxPositionCar.position;
    }

    public String getName() {
        return name;
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
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
