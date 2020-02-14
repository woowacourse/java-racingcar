package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void getWinnersForEmptyCars() {
		Cars cars = new Cars(new ArrayList<>());
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(cars::getWinners)
				.withMessage("차가 존재하지 않습니다.");
	}

	@Test
	void getWinners() {
		Car finn = new Car("핀", 5);
		Car kouz = new Car("코즈", 3);
		Cars cars = new Cars(Arrays.asList(finn, kouz));
		List<Car> expected = Arrays.asList(finn);
		List<Car> actual = cars.getWinners();
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getPositions() {
		Car finn = new Car("핀", 7);
		Car kouz = new Car("코즈", 9);
		Cars cars = new Cars(Arrays.asList(finn, kouz));
		Map<String, Integer> expected = new HashMap<>();
		expected.put(finn.getName(), 7);
		expected.put(kouz.getName(), 9);
		Map<String, Integer> actual = cars.getPositions();
		assertThat(actual).isEqualTo(expected);
	}
}
