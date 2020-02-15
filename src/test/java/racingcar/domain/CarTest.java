package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

	@Test
	void testRun() {
		car = new Car(new Name("붕붕"));
		car.move(new PowerLevel(4));
		assertThat(car).extracting("position").isEqualTo(1);
	}

	@Test
	void testStop() {
		car = new Car(new Name("붕붕"));
		car.move(new PowerLevel(0));
		assertThat(car).extracting("position").isEqualTo(0);
	}

	@Test
	void getFartherCarTest() {
		car = new Car(new Name("붕붕"));
		Car car2 = new Car(new Name("붕붕2"), new Position(2));
		assertThat(car.getFartherCar(car2)).isEqualTo(car2);
	}

	@Test
	void isSamePositionCarTest_true() {
		car = new Car(new Name("붕붕"));
		Car car2 = new Car(new Name("붕붕2"), new Position(0));
		assertThat(car.isSamePosition(car2)).isTrue();
	}

	@Test
	void isSamePositionCarTest_false() {
		car = new Car(new Name("붕붕"));
		Car car2 = new Car(new Name("붕붕2"), new Position(2));
		assertThat(car.isSamePosition(car2)).isFalse();
	}
}
