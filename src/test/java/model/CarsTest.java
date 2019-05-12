/*
 * @(#)CarsTest.java      1.0 2019/05/12
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
class CarsTest {
    /*게임 진행하는 자동차들을 테스팅 하는 클래스*/
    @Test
    void 최초차이름들_입력형식_검사_콤마시작() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Cars(",pobi");
        });
    }

    @Test
    void 최초차이름들_입력형식_검사_콤마끝() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("pobi,");
        });
    }

    @Test
    void 최초차이름들_입력형식_검사_빈문자열() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("");
        });
    }

    @Test
    void 최초차이름들_입력형식_검사_콤마두개() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("pobi,,coogie");
        });
    }

    @Test
    void 최초차이름들_입력형식_검사_중복이름() {
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("abc,abc");
        });
    }
}