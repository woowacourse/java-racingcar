package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	@DisplayName("자동차들이 주어진 동력에 따라 동작하는지 테스트")
	@ParameterizedTest
	@CsvSource({"0,0,true", "3,0,true", "4,1,true", "5,1,true", "9,1,true"
		, "0,1,false", "3,1,false", "4,0,false", "5,0,false", "9,0,false"})
	void carsRunTest(int powerLevel, int expectedPosition, boolean expected) {
		Cars cars = CarsFactory.createCars("또링,동글");
		PowerGenerator enoughPowerGenerator = () -> new Power(powerLevel);
		cars.moveAll(enoughPowerGenerator);
		boolean result = isAllRightPosition(cars, expectedPosition);
		assertThat(result).isEqualTo(expected);
	}

	private boolean isAllRightPosition(Cars cars, int position) {
		boolean result = true;
		Car carWithTestPosition = new Car("test", position);

		for (Car car : cars) {
			result = car.isSamePosition(carWithTestPosition);
		}
		return result;
	}

	@DisplayName("우승자 목록 구하기 테스트")
	@Test
	void findWinnerTest() {
		List<Car> rawCars = Arrays.asList(new Car("또링", 20),
			new Car("동글", 20), new Car("큰곰", 5));
		Cars cars = new Cars(rawCars);
		assertThat(cars.findWinners()).containsExactly(new Car("또링", 20),
			new Car("동글", 20));
	}
}
