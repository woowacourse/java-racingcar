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
    @Test
    void 차_전진_정지_검사() {
        Car car1 = new Car(new CarName("coogi"),3);
        car1.move(4);
        assertThat(new Car(new CarName("coogi"),4)).isEqualTo(car1);

        Car car2 = new Car(new CarName("coogi"));
        car2.move(0);
        assertThat(new Car(new CarName("coogi"))).isEqualTo(car2);

        Car car3 = new Car(new CarName("coogi"));
        car3.move(9);
        assertThat(new Car(new CarName("coogi"),1)).isEqualTo(car3);
    }
}