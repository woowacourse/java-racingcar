package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movingstrategy.ForwardMovingStrategy;
import racingcar.movingstrategy.MovingStrategy;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * CarsTest.java
 * Cars 기능 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
class CarsTest {
    private Cars cars;
    private MovingStrategy movingStrategy = ForwardMovingStrategy.getInstance();

    @BeforeEach
    void setUp() {
        List<Car> carList = Arrays.asList(new Car("또링", 20, movingStrategy), new Car("동글", 20, movingStrategy),
                new Car("알트", 15, movingStrategy));
        cars = new Cars(carList);
    }

    @DisplayName("우승자 목록 구하기 테스트")
    @Test
    void testFindWinner() {
        assertThat(cars.findWinner()).containsExactly(new Car("또링", 20, movingStrategy), new Car("동글", 20, movingStrategy));
    }

    @DisplayName("run 메소드 실행 시, 모든 자동차가 제대로 동작하는지 테스트")
    @Test
    void testRun() {
        cars.run();
        cars.run();

        assertThat(cars).containsExactly(new Car("또링", 22, movingStrategy), new Car("동글", 22, movingStrategy),
                new Car("알트", 17, movingStrategy));
    }
}
