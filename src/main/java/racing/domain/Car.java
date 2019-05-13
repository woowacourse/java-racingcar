/*
 * @(#)Car.java
 *
 * v 2.0.0
 *
 * 2019.05.11
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
    private static final String NAME_EXCEPTION_MESSAGE = "양식에 맞게 다시 입력해주세요 ! (이름은 쉼표(,) 기준으로 구분)";
    public static final String POSITION_EXCEPTION_MESSAGE = "포지션은 양수.";
    private static final char CHAR_HYPHEN = '-';

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validName(name);
        validPosition(position);
        this.name = name;
        this.position = position;
    }

    private void validName(String name) {
        if (!name.matches("[a-zA-Z0-9]{1,5}")) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
    }

    private void validPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(POSITION_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.getPosition();
    }

    public String positionVisualize() {
        char[] pos = new char[this.position];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = CHAR_HYPHEN;
        }
        return String.copyValueOf(pos);
    }

    public void moveByRandomNumber(Rule rule) {
        if (rule.goOrStop()) {
            goForward();
        }
    }

    private void goForward() {
        this.position++;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
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
        return position == car.position &&
                Objects.equals(name, car.name);
    }
}
