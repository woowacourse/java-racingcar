package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	private Cars cars;

	@DisplayName("이동거리 최댓값을 가지는 Car 찾기")
	@Test
	void cars_max_position_car() {
		//given
		Cars cars = new Cars(check_ranking_if_correct());
		//when
		List<String> winners = cars.findWinners();
		//then
		assertThat(winners.size() == 3).isTrue();
	}

	@DisplayName("공동 승리")
	@Test
	void cars_winners() {
		//given
		cars = new Cars(check_ranking_if_correct());
		//when
		List<String> winners = cars.findWinners();
		//then
		assertThat(winners).containsExactly("bong", "su", "dal");
	}

	private List<Car> check_ranking_if_correct() {
		return Arrays.asList(new Car("hee", 2),
			new Car("bong", 3),
			new Car("su", 3),
			new Car("dal", 3),
			new Car("good", 1)
		);
	}
}