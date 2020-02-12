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

	@DisplayName("각 카를 돌며 가장 멀리 간 거리를 알아내서 ")
	@Test
	void testFindMaxPositionCar() {
		List<String> names = Arrays.asList("또링", "동글");
		List<Integer> position = Arrays.asList(5, 20);
		Cars cars = new Cars(names, position);
		assertThat(cars.findMaxPositionCar()).isEqualTo(new Car("동글", 20));
	}
}
