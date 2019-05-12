/*
 * @(#)Car.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package model;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class CarName {
    /*자동차 이름에 관한 클래스*/
    private final String name;
    private static final String regexCarName = "^([a-zA-Z]{1,5})$";

    public CarName(String name) {
        if (!name.matches(regexCarName)) {
            throw new IllegalArgumentException("자동차 이름은 영어로 구성되고 길이는 1~5입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
