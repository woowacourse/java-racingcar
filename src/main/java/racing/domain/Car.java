/*
 * @(#)Car.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.domain;

import java.util.Objects;

/**
 * 레이싱 게임의 자동차 한 대를 위한 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 2.0.0
 * @see Comparable
 */
public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 0;
    private static final int GO_FORWARD_CRITERIA = 4;

    private final String name;
    private int position;

    Car(String name) {
        this(name, INIT_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name;
    }

    void movePosition(int rand) {
        if (moveOrNot(rand)) {
            position++;
        }
    }

    static boolean moveOrNot(int randomNum) {
        return randomNum >= GO_FORWARD_CRITERIA;
    }

    boolean matchPosition(int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }

    String positionResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append('-');
        }
        sb.append("\n");
        return sb.toString();
    }

    Car copyCar() {
        return new Car(this.name, this.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return this.position == car.position &&
                Objects.equals(name, car.name);
    }
}
