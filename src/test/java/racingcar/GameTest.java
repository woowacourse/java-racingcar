package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.UniqueCars;

public class GameTest {
	@Test
	public void 우승자_판정() {
		Car winner = new Car("forky");
		Car loser = new Car("kun");
		winner.move();
		Game game = new Game(new UniqueCars(List.of(winner, loser)));
		assertThat(game.getWinners())
			.contains(winner);
	}

	@Test
	public void 우승자_여러명() {
		Car winner1 = new Car("pobi");
		Car winner2 = new Car("kun");
		Car loser = new Car("forky");
		winner1.move();
		winner2.move();
		Game game = new Game(new UniqueCars(List.of(winner1, winner2, loser)));
		assertThat(game.getWinners())
			.containsExactlyInAnyOrder(winner1, winner2);
	}
}
