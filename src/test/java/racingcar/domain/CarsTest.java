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
	private Car firstCar;
	private Car secondCar;

	@BeforeEach
	void setUp() {
		firstCar = new Car(new Name("또링"));
		secondCar = new Car(new Name("동글"));
	}

	@Test
	void carsRunTest_move_all() {
		Cars cars = new Cars(Arrays.asList(firstCar, secondCar));
		PowerGenerator powerGenerator = () -> new PowerLevel(5);
		cars.moveAll(powerGenerator);
		boolean result = isAllRightPosition(cars, 1);
		assertThat(result).isTrue();
	}

	@Test
	void carsRunTest_stop_all() {
		Cars cars = new Cars(Arrays.asList(firstCar, secondCar));
		PowerGenerator powerGenerator = () -> new PowerLevel(0);
		cars.moveAll(powerGenerator);
		boolean result = isAllRightPosition(cars, 0);
		assertThat(result).isTrue();
	}

	private boolean isAllRightPosition(Cars cars, int position) {
		boolean result = true;
		Car carWithTestPosition = new Car(new Name("test"), new Position(position));

		for (Car car : cars) {
			result = car.isSamePosition(carWithTestPosition);
		}
		return result;
	}

	@DisplayName("우승자 목록 구하기 테스트")
	@Test
	void testFindWinner() {
		List<Car> rawCars = Arrays.asList(new Car(new Name("또링"), new Position(20)),
			new Car(new Name("동글"), new Position(20)), new Car(new Name("알트"), new Position(15)),
			new Car(new Name("큰곰"), new Position(5)));
		Cars cars = new Cars(rawCars);
		assertThat(cars.findWinners()).containsExactly(new Car(new Name("또링"), new Position(20)),
			new Car(new Name("동글"), new Position(20)));
	}
}
