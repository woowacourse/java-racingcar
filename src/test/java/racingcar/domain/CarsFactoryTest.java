package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Splitter.java
 * 문자열 분리가 정상적으로 되었는지 테스트하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class CarsFactoryTest {
	private Car firstCar;
	private Car secondCar;

	@BeforeEach
	void setUp() {
		firstCar = new Car(new Name("또링"));
		secondCar = new Car(new Name("동"));
	}

	@DisplayName("이름을 통해 자동차들 정상적으로 생성되었는지 테스트")
	@Test
	void Should_success_When_appropriateValue() {
		Assertions.assertThat(CarsFactory.createCars("네오,프로도,튜브"))
			.containsExactly(new Car(new Name("네오")), new Car(new Name("프로도")), new Car(new Name("튜브")));
	}

	@DisplayName("입력받은 이름 중 1~5자 사이가 아닌 글자 들어간 경우 실패")
	@ParameterizedTest
	@ValueSource(strings = {"네오네오빔빔,검은고양이네로", "콘,검은고양이네로"})
	void Should_exception_When_inappropriateNameLength(String input) {
		assertThatThrownBy(() -> CarsFactory.createCars(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("name must be between 1-5");
	}

	@DisplayName("최소한의 차 갯수 미만의 차 목록 생성 실패")
	@Test
	void try_to_construct_carsObject_with_less_than_minimum_test() {
		assertThatThrownBy(() -> CarsFactory.createCars("또링"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("목록 내 중복된 이름 존재시 차 목록 생성 실패")
	@Test
	void try_to_construct_carsObject_with_duplicate_name_test() {
		assertThatThrownBy(() -> CarsFactory.createCars("또링,동글,또링"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
