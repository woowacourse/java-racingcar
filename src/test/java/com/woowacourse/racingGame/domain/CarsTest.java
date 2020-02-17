package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
	private MovableStrategy movableStrategy;

	@Test
	void checkDuplicate_유효한_이름() {
		movableStrategy = new RandomMovableStrategy();
		List<Car> nonDuplicatedCars = Arrays.asList(
			new Car(new Name("a"), movableStrategy),
			new Car(new Name("bb"), movableStrategy),
			new Car(new Name("ccc"), movableStrategy));
		Cars cars = new Cars(nonDuplicatedCars);

		final List<Car> actual = cars.getCars();

		assertThat(actual).isEqualTo(nonDuplicatedCars);
	}

	@Test
	void checkDuplicate_중복된_이름_존재() {
		movableStrategy = new RandomMovableStrategy();
		List<Car> duplicatedCars = Arrays.asList(
			new Car(new Name("a"), movableStrategy),
			new Car(new Name("bb"), movableStrategy),
			new Car(new Name("a"), movableStrategy));

		assertThatThrownBy(() -> new Cars(duplicatedCars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 이름이 존재합니다.");
	}

	@Test
	void attemptMove_전부_이동() {
		//given
		movableStrategy = new PlannedMovableStrategy(new Power(9));
		List<Car> nonDuplicatedCars = Arrays.asList(
			new Car(new Name("a"), movableStrategy),
			new Car(new Name("bb"), movableStrategy),
			new Car(new Name("ccc"), movableStrategy));
		Cars cars = new Cars(nonDuplicatedCars);

		//when
		//then
	}
}
