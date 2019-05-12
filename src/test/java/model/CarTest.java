/*
 * @(#)CarTest.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
class CarTest {
    /*자동차 동작을 테스팅하는 클래스*/
    Car car;

    @Test
    void 차_전진_검사() {
        car = new Car(new CarName("coogi"),3);
        car.move(4);
        assertThat(new Car(new CarName("coogi"),4)).isEqualTo(car);
    }

    @Test
    void 차_정지_검사() {
        car = new Car(new CarName("coogi"),3);
        car.move(3);
        assertThat(new Car(new CarName("coogi"),3)).isEqualTo(car);
    }
}