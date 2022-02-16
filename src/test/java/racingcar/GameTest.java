package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.MoveStrategy;
import racingcar.domain.UniqueCars;

public class GameTest {
	private final MoveStrategy neverMove = () -> false;
	private final MoveStrategy alwaysMove = () -> true;

	@Test
	@DisplayName("무조건 false를 반환하는 MoveStrategy 일 때 Car 이동")
	public void play_MoveStrategy_false() {
		Car car = new Car("forky");
		Game game = new Game(new UniqueCars(List.of(car)));
		game.play(neverMove);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("무조건 true를 반환하는 MoveStrategy 일 때 Car 이동")
	public void play_MoveStrategy_true() {
		Car car = new Car("forky");
		Game game = new Game(new UniqueCars(List.of(car)));
		game.play(alwaysMove);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("우승자가 한 명일 때 우승자 판정")
	public void getWinners_one_winner() {
		Car winner = new Car("forky");
		Car loser = new Car("kun");
		winner.move();
		Game game = new Game(new UniqueCars(List.of(winner, loser)));
		assertThat(game.getWinners())
			.contains(winner);
	}

	@Test
	@DisplayName("우승자가 두 명일 때 우승자 판정")
	public void getWinners_two_winners() {
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
