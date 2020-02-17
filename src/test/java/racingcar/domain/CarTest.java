package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.movingstrategy.ForwardMovingStrategy;
import racingcar.movingstrategy.MovingStrategy;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * CarTest.java
 * car 객체 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
class CarTest {
    private Car car;

    @DisplayName("이름을 받아 car 객체를 정상적으로 생성")
    @ParameterizedTest
    @ValueSource(strings = {"또링", "동글"})
    void testCar(String name) {
        car = new Car(name);
        assertThat(car).isNotNull();
    }

    @DisplayName("무조건 전진하는 전략을 사용했을 때, 자동차가 실제로 전진하는지 테스트")
    @Test
    void testRun() {
        MovingStrategy movingStrategy = ForwardMovingStrategy.getInstance();
        car = new Car("붕붕", 0, movingStrategy);

        car.run();
        car.run();

        assertThat(car).extracting("position").isEqualTo(2);
    }
}
