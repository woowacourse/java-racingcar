package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayersFactoryTest {

	@Test
	void create() {
		// given
		String input = "kueni,a,pobi";

		// when
		Players players = PlayersFactory.create(input);

		// then
		Player player1 = new Player(new Name("kueni"));
		Player player2 = new Player(new Name("a"));
		Player player3 = new Player(new Name("pobi"));

		Assertions.assertThat(players.getUnmodifiableList())
				.containsExactly(player1, player2, player3);
	}

	@Test
	void create_ShouldPlayerIsNotReady() {
		// given
		String input = "kueni,abcdef,pobi";

		// when
		Players players = PlayersFactory.create(input);

		// then
		Assertions.assertThat(players.isReady())
				.isFalse();
	}
}