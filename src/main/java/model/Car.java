/*
 * @(#)Car.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package model;

import java.util.Objects;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class Car implements Comparable<Car>, Cloneable {
    /*자동차에 관한 클래스*/
    private static final int MOVE_BOUND = 4;
    private final String name;
    private int position;

    public Car(CarName carName) {
        this.name = carName.getName();
    }

    public Car(CarName carName, int position) {
        this.name = carName.getName();
        this.position = position;
    }

    public String getName() {
        return name;
    }

    void move(int number) {
        if (isMove(number)) {
            this.position++;
        }
    }

    private boolean isMove(int number) {
        return number >= MOVE_BOUND;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.append("\n").toString();
    }

    public Car copy() throws CloneNotSupportedException {
        return (Car) this.clone();
    }
}
