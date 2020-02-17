package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class ResultTest {
	private final MovableStrategy movableStrategy = new RandomMovableStrategy();

	@Test
	void getRacingCarStatus_게임을_진행한_자동차() {
		final List<Car> racingCar = Arrays.asList(
			new Car(new Name("car1"), Position.valueOf(3), movableStrategy),
			new Car(new Name("car2"), Position.valueOf(2), movableStrategy),
			new Car(new Name("car3"), Position.valueOf(1), movableStrategy));
		final Result result = new Result(new Cars(racingCar));

		final Map<String, Integer> actual = result.getRacingCarStatus();

		final Map<String, Integer> expected = new HashMap<String, Integer>() {{
			put("car1", 3);
			put("car2", 2);
			put("car3", 1);
		}};

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getWinners_우승한_자동차() {
		int winnerPosition = 7;
		List<Car> inGameCars = Arrays.asList(
			new Car(new Name("car1"), Position.valueOf(winnerPosition - 1), movableStrategy),
			new Car(new Name("car2"), Position.valueOf(winnerPosition), movableStrategy),
			new Car(new Name("car3"), Position.valueOf(winnerPosition - 2), movableStrategy),
			new Car(new Name("car4"), Position.valueOf(winnerPosition), movableStrategy));
		Cars cars = new Cars(inGameCars);
		Result result = new Result(cars);

		List<String> actual = result.getWinners();

		List<String> expected = Arrays.asList("car2", "car4");

		assertThat(actual).isEqualTo(expected);
	}
}
