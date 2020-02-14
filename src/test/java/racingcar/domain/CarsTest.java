package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
	//private Cars cars2;

	@BeforeEach
	void setUp() {
		List<Car> cars = Arrays.asList(new Car(new Name("또링"), 20), new Car(new Name("동글"), 20), new Car(new Name("알트"), 15), new Car(new Name("큰곰"), 5));
	//	cars2 = new Cars(cars);
	}

	@DisplayName("최소한의 차 갯수 미만의 차 목록 생성 실패")
	@Test
	void try_to_construct_carsObject_with_less_than_minimum_test() {
		List<Car> cars = Arrays.asList(new Car(new Name("또링")));
		assertThatThrownBy(() -> new Cars(cars))
			.isInstanceOf(IllegalArgumentException.class);
			//.hasMessage("name can not be null or blank");
	}

	@DisplayName("목록 내 중복된 이름 존재시 차 목록 생성 실패")
	@Test
	void try_to_construct_carsObject_with_duplicate_name_test() {
		List<Car> cars = Arrays.asList(new Car(new Name("또링")), new Car(new Name("또링")));
		assertThatThrownBy(() -> new Cars(cars))
			.isInstanceOf(IllegalArgumentException.class);
			//.hasMessage("name must be between 1-5");
	}

	// @DisplayName("우승자 목록 구하기 테스트")
	// @Test
	// void testFindWinner() {
	// 	assertThat(cars.findWinner()).containsExactly(new Car(new Name("또링"), 20), new Car(new Name("동글"), 20));
	// }
}
