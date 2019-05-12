/*
 * @(#)CarNameTest.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
class CarNameTest {
    /*자동차 이름을 테스팅하는 클래스*/
    @Test
    void 차이름_중간공백_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("a bcd");
        });
    }

    @Test
    void 차이름_공백시작_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName(" bcd");
        });
    }

    @Test
    void 차이름_공백끝_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("bcd ");
        });
    }

    @Test
    void 차이름_길이초과_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("abcdef");
        });
    }

    @Test
    void 차이름_숫자포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("a1bcd");
        });
    }

    @Test
    void 차이름_특수문자포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("!bcd");
        });
    }


}