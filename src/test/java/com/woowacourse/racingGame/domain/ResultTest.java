package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ResultTest {
	@Test
	void getRacingCarStatus_게임을_진행한_자동차() {
		final List<Car> racingCar = Arrays.asList(
			new Car(new Name("car1"), new Position(3)),
			new Car(new Name("car2"), new Position(2)),
			new Car(new Name("car3"), new Position(1)));
		final Result result = new Result(new Cars(racingCar));

		final List<String> actual = result.getRacingCarStatus();

		final List<String> expected = Arrays.asList("car1 : ---", "car2 : --", "car3 : -");

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getWinners_우승한_자동차() {
		int winnerPosition = 7;

		List<Car> inGameCars = Arrays.asList(
			new Car(new Name("car1"), new Position(winnerPosition - 1)),
			new Car(new Name("car2"), new Position(winnerPosition)),
			new Car(new Name("car3"), new Position(winnerPosition - 2)),
			new Car(new Name("car4"), new Position(winnerPosition)));
		Cars cars = new Cars(inGameCars);
		Result result = new Result(cars);

		List<String> actual = result.getWinners();

		List<String> expected = Arrays.asList("car2", "car4");

		assertThat(actual).isEqualTo(expected);
	}
}
