package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

	@BeforeEach
	void setUp() {
		car = new Car("붕붕");
	}

	@DisplayName("이름을 받아 car 객체를 정상적으로 생성")
	@ParameterizedTest
	@ValueSource(strings = {"또링", "동글"})
	void testCar(String name) {
		car = new Car(name);
		assertThat(car).isNotNull();
	}

	@DisplayName("동력이 주어진 경우, 자동차가 움직이는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"4,1", "9,1", "3,0", "0,0"})
	void testRunOrStop(int powerLevel, int expectedPosition) {
		car.move(new Power(powerLevel));
		assertThat(car).extracting("position").isEqualTo(expectedPosition);
	}

	@DisplayName("두 자동차중 더 멀리나간 자동차를 반환하는지 테스트")
	@Test
	void getFartherCarTest() {
		Car car2 = new Car("붕붕2", 2);
		assertThat(car.getFartherCar(car2)).isEqualTo(car2);
	}

	@DisplayName("두 자동차가 같은 위치에 있는지 반환하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0,true", "2,false"})
	void isSamePositionCar_test(int position, boolean expected) {
		Car car2 = new Car("붕붕2", position);
		assertThat(car.isSamePosition(car2)).isEqualTo(expected);
	}
}
