package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import racing.domain.Car;
import racing.domain.RacingGame;

public class RacingGameTest {
	@Test
	public void winnerTest() {
		List<Car> cars = Arrays.asList(
			new Car("자동차1", 5),
			new Car("자동차2", 7),
			new Car("자동차3", 1));
		RacingGame racingGame = new RacingGame(cars);
		List<Car> winners = racingGame.findWinner();
		String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining(","));

		assertThat(winnersName).contains("자동차2");
		assertThat(winnersName).doesNotContain("자동차1");
	}
}
