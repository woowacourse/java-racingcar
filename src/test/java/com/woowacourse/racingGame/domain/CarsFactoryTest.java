package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarsFactoryTest {
	@Test
	void generate_Cars_생성() {
		final String inputCarName = "car1,car2,car3,car4";
		final MovableStrategy movableStrategy = new RandomMovableStrategy();
		final List<Car> cars = Arrays.asList(
			new Car(new Name("car1"), movableStrategy),
			new Car(new Name("car2"), movableStrategy),
			new Car(new Name("car3"), movableStrategy),
			new Car(new Name("car4"), movableStrategy));

		final Cars actual = CarsFactory.generate(inputCarName, movableStrategy);

		final Cars expect = new Cars(cars);

		assertThat(actual).isEqualTo(expect);
	}
}
