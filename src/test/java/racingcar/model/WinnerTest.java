package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class WinnerTest {

	@Test
	void 우승자_선정() {
		List<Car> cars = Arrays.asList(
			new Car("aa", 3), new Car("bb", 2),
			new Car("cc", 2), new Car("dd", 1));
		Winner winner = new Winner();

		assertThat(winner.getWinners(cars)).contains("aa");
	}

	@Test
	void 우승자_여러명_선정() {
		List<Car> cars = Arrays.asList(
			new Car("aa", 3), new Car("bb", 2),
			new Car("cc", 3), new Car("dd", 1));
		Winner winner = new Winner();

		assertThat(winner.getWinners(cars)).contains("aa", "cc");
	}
}
