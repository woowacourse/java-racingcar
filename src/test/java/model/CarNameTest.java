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
    void 차이름_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("a bcd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("a1bcd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("abcdef");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("!bcd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName(" asd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("asd ");
        });
    }
}