package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

class CarsTest {
	private Cars cars;

	@BeforeEach
	void setUp() {
		List<Car> carList = Arrays.asList(new Car("또링", 20), new Car("동글", 20), new Car("알트", 15), new Car("큰곰", 5));
		cars = new Cars(carList);
	}

	@DisplayName("우승자 목록 구하기 테스트")
	@Test
	void testFindWinner() {
		assertThat(cars.findWinner()).containsExactly(new Car("또링", 20), new Car("동글", 20));
	}
}
