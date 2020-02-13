package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void checkDuplicate_유효한_이름() {
		List<Car> nonDuplicatedCars = Arrays.asList(
			new Car(new Name("a")),
			new Car(new Name("bb")),
			new Car(new Name("ccc")));

		Cars cars = new Cars(nonDuplicatedCars);

		Assertions.assertThat(cars.getCars()).isEqualTo(nonDuplicatedCars);
	}

	@Test
	void checkDuplicate_중복된_이름_존재() {
		List<Car> duplicatedCars = Arrays.asList(
			new Car(new Name("a")),
			new Car(new Name("bb")),
			new Car(new Name("a")));

		assertThatThrownBy(() -> new Cars(duplicatedCars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 이름이 존재합니다.");
	}
}
