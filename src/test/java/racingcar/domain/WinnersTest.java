package racingcar.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

	@Test
	@DisplayName("우승자가 한 명인 경우 테스트")
	void getOneWinner() {
		List<Car> cars = Arrays.asList(
			new Car("pobi", 2),
			new Car("crong", 3),
			new Car("honux", 1)
		);
		Winners winners = new Winners(cars);
		assertThat(winners.getNames()).contains("crong");
	}

	@Test
	@DisplayName("우승자가 여러명인 경우 테스트")
	void getSeveralWinner() {
		List<Car> cars = Arrays.asList(
			new Car("pobi", 3),
			new Car("crong", 3),
			new Car("honux", 1)
		);
		Winners winners = new Winners(cars);
		assertThat(winners.getNames()).contains("pobi", "crong");
	}
}
