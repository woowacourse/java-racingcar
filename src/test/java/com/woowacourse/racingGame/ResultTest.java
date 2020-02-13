package com.woowacourse.racingGame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.woowacourse.racingGame.domain.Car;
import com.woowacourse.racingGame.domain.Cars;
import com.woowacourse.racingGame.domain.Name;

public class ResultTest {
	@Test
	void getWinners_우승한_자동차() {
		Result result = new Result();
		int winnerPosition = 7;

		List<Car> inGameCars = Arrays.asList(
			new Car(new Name("car1")),
			new Car(new Name("car2")),
			new Car(new Name("car3")),
			new Car(new Name("car4")));

		inGameCars.get(0).setPosition(winnerPosition - 1);
		inGameCars.get(1).setPosition(winnerPosition);
		inGameCars.get(2).setPosition(winnerPosition - 2);
		inGameCars.get(3).setPosition(winnerPosition);

		Cars cars = new Cars(inGameCars);

		List<String> actual = result.getWinners(cars);

		List<String> expected = Arrays.asList("car2", "car4");

		assertThat(actual).isEqualTo(expected);
	}
}
