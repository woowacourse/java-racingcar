package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RacingCarsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	public void 중복된_이름() {
		assertThatThrownBy(() -> new RacingCars(CarFactory.of("forky,forky")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 우승자_판정() {
		Car winner = new Car("forky");
		Car loser = new Car("kun");
		winner.move();
		assertThat(new RacingCars(List.of(winner, loser)).getWinners())
			.contains(winner);
	}

	@Test
	public void 우승자_여러명() {
		Car winner1 = new Car("pobi");
		Car winner2 = new Car("kun");
		Car loser = new Car("forky");
		winner1.move();
		winner2.move();
		assertThat(new RacingCars(List.of(winner1, winner2, loser)).getWinners())
			.containsExactlyInAnyOrder(winner1, winner2);
	}
}
