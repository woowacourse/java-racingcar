package domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("우승자")
class WinnerTest {
	Cars cars = new Cars(new ArrayList<>(List.of(
		new Car("benz"),
		new Car("honda"),
		new Car("audi")
	)));

	@DisplayName("를 확인합니다.")
	@Test
	void checkWinner() {

		cars.addDistance(8, 0);
		cars.addDistance(3, 1);
		cars.addDistance(5, 2);

		cars.addDistance(7, 0);
		cars.addDistance(2, 1);
		cars.addDistance(0, 2);

		Winner winner = new Winner(cars);
		assertThat(String.join("", winner.getWinners())).isEqualTo("benz");
	}

	@DisplayName("는 여러명일 수 있습니다.")
	@Test
	void checkManyWinners() {
		cars.addDistance(8, 0);
		cars.addDistance(3, 1);
		cars.addDistance(5, 2);

		cars.addDistance(7, 0);
		cars.addDistance(2, 1);
		cars.addDistance(9, 2);

		Winner winner = new Winner(cars);
		assertThat(String.join(",", winner.getWinners())).isEqualTo("benz,audi");
	}
}
