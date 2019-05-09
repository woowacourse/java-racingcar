/*
 * @(#)Car.java
 *
 * v 1.0.0
 *
 * 2019.05.08
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.domain;

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

    private static final int GO_FORWARD_CRITERIA = 4;

    private final String name;
    private Integer status = 1;

    Car(String name) {
        if (!name.matches("[0-9a-zA-Z]{1,5}")) {
            throw new IllegalArgumentException(NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }
    //Test Fixture를 위해 생성자 추가
    Car(String name, int status) {
        this.name = name;
        this.status = status;
    }

    Integer getStatus() {
        return status;
    }

    String getName() {
        return name;
    }

    void moveOneTime() {
        int rand = generateRandomNumber();
        if (goOrStop(rand)) {
            status++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return this.status.compareTo(o.status);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private boolean goOrStop(int randomNum) {
        return randomNum >= GO_FORWARD_CRITERIA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" : ");
        for (int i = 0; i < this.status; i++) {
            sb.append('-');
        }
        sb.append("\n");
        return sb.toString();
    }
}
