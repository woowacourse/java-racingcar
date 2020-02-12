package racingcar.domain;
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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@DisplayName("이름을 받아 car 객체를 정상적으로 생성")
	@ParameterizedTest
	@ValueSource(strings = {"또링", "동글"})
	void testCar(String name) {
		Car car = new Car(name);
		Assertions.assertThat(car).isNotNull();
	}

}
