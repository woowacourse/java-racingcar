package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
public class CarTest {
	private Car car;

	@DisplayName("이름을 받아 car 객체를 정상적으로 생성")
	@ParameterizedTest
	@ValueSource(strings = {"또링", "동글"})
	void testCar(String name) {
		car = new Car(new Name(name));
		assertThat(car).isNotNull();
	}

	@DisplayName("입력받은 수에 따라 자동차가 동작")
	@ParameterizedTest
	@CsvSource(value = {"0:0", "1:0", "2:0", "3:0",
		"4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
	void testRun(int randomNumber, int position) {
		car = new Car(new Name("붕붕"));
		car.run(randomNumber);
		assertThat(car).extracting("position").isEqualToComparingOnlyGivenFields(position);
	}
}
