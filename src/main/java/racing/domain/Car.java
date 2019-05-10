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

import racing.controller.Controller;

/**
 * 레이싱 게임의 자동차 한 대를 위한 클래스
 *
 * @author imkimheejoo
 * @author kwonmc
 * @version 1.0.0
 * @see Comparable
 */
public class Car implements Comparable<Car> {
    private static final String NAME_EXCEPTION_MESSAGE = "양식에 맞는 이름을 입력해주세요 !";

    private final String name;
    private Integer position;

    Car(String name) {
        this(name, 1);
    }

    //Test Fixture 위해 생성자 추가
    Car(String name, Integer position) {
        validName(name);
        this.name = name;
        this.position = position;
    }

    private void validName(String name) {
        if (!name.matches("[0-9a-zA-Z]{1,5}")) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
    }

    Integer getPosition() {
        return position;
    }

    String getName() {
        return name;
    }

    void moveOneTime(int rand) {
        if (Controller.move(rand)) {
            position++;
        }
    }

    boolean matchPosition(int position) {
        return this.position.equals(position);
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

    String positionResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append('-');
        }
        sb.append("\n");
        return sb.toString();
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
        return position.equals(car.position) &&
                Objects.equals(name, car.name);
    }
}
