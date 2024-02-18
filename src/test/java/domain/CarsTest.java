package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.strategy.MovingStrategy;
import domain.strategy.RandomNumberMovingStrategy;

class CarsTest {
	Cars cars;

	@BeforeEach
	void setUP() {
		MovingStrategy movingStrategy = new RandomNumberMovingStrategy();
		cars = new Cars(List.of(
			new Car("a", 0, movingStrategy),
			new Car("b", 1, movingStrategy),
			new Car("c", 2, movingStrategy),
			new Car("d", 1, movingStrategy),
			new Car("e", 2, movingStrategy)
		));
	}

	@DisplayName("가장 많이 이동한 차량의 위치 확인")
	@Test
	void getLargestLocation() {
		assertThat(cars.getLargestLocation()).isEqualTo(2);
	}

	@DisplayName("각 차량의 현재 위치 반환 확인")
	@Test
	void getCurrentLocations() {
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("a", 0);
		expected.put("b", 1);
		expected.put("c", 2);
		expected.put("d", 1);
		expected.put("e", 2);

		assertThat(cars.getCurrentLocations()).isEqualTo(expected);
	}

	@DisplayName("가장 많이 이동한 차량 이름 반환 확인")
	@Test
	void getLargestLocationCarsName() {
		List<String> expected = List.of("c", "e");

		assertThat(cars.getLargestLocationCarsName()).isEqualTo(expected);
	}
}