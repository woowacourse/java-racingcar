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
    void 최초차이름들_입력형식_및_중복검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Cars(",pobi,");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("pobi,");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("pobi,,coogie");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("abc,abc");
        });
    }
}