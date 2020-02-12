package com.woowacourse.racingGame.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.Name;

public class CarsFactoryTest {
	@Test
	void generate_Cars_생성() {
		final String inputCarName = "car1,car2,car3,car4";
		final List<Car> cars = Arrays.asList(
			new Car(new Name("car1")),
			new Car(new Name("car2")),
			new Car(new Name("car3")),
			new Car(new Name("car4")));

		final Cars actual = CarsFactory.generate(inputCarName);

		final Cars expect = new Cars(cars);

		assertThat(actual).isEqualTo(expect);
	}
}
