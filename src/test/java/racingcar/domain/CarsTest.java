package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

public class CarsTest {
    @DisplayName("가장 멀리간 자동차 구하기 테스트")
    @Test
    void testFindMaxPositionCar() {
        List<String> names = Arrays.asList("또링", "동글", "알트");
        List<Integer> position = Arrays.asList(5, 20, 10);
        Cars cars = new Cars(names, position);
        assertThat(cars.findMaxPositionCar()).isEqualTo(new Car("동글", 20));
    }

    @DisplayName("우승자 목록 구하기 테스트")
    @Test
    void testFindWinner() {
        List<String> names = Arrays.asList("또링", "동글", "알트", "큰곰");
        List<Integer> position = Arrays.asList(20, 20, 15, 5);
        Cars cars = new Cars(names, position);
        assertThat(cars.findWinner()).containsExactly(new Car("또링", 20), new Car("동글", 20));
    }
}
