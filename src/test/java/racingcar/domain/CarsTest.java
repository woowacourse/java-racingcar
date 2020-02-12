package racingcar.domain;
/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * CarsTest.java
 * cars 객체 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@DisplayName("이름목록을 받아 cars 객체를 정상적으로 생성")
	@Test
	void testCar() {
		List<String> names = Arrays.asList("또링", "동글");
		Cars cars = new Cars(names);
		Assertions.assertThat(cars).isNotNull();
	}
}
