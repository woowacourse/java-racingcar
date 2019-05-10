package com.woowacourse.javaracingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void testCreate() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void testMove() {
        Car car = new Car("pobi");
        car.move(2);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(5);
    }
}
