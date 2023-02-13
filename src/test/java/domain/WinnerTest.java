package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("우승자")
class WinnerTest {
	static Cars cars;

	@DisplayName("를 확인합니다.")
	@Test
	void checkWinner() {
		cars = new Cars(new ArrayList<>(List.of(
			new Car("benz", 3)
		)));
		Winner winner = new Winner(cars);
		assertThat(winner.getWinners()).isEqualTo(List.of("benz"));
	}

	@DisplayName("는 여러명일 수 있습니다.")
	@Test
	void checkManyWinners() {
		cars = new Cars(new ArrayList<>(List.of(
			new Car("benz", 3),
			new Car("honda", 3),
			new Car("audi", 1)
		)));

		Winner winner = new Winner(cars);
		assertThat(winner.getWinners()).isEqualTo(List.of("benz", "honda"));
	}
}
