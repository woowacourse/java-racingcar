package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingCar.domain.classForTest.TestDeciderFactory;

import java.util.List;

class RacingCarTest {
	RacingCar racingCar;

	@BeforeEach
	void setUp() {
		// given
		Players players = PlayersFactory.create("a,b,c,d");
		racingCar = new RacingCar(players, 10);
	}

	@Test
	void race() {
		// when
		racingCar.race(new TestDeciderFactory());

		// then
		Assertions.assertThat(racingCar.getRound())
				.isEqualTo(1);
		Assertions.assertThat(racingCar.getPlayerPositions())
				.containsExactly(1, 1, 1, 1);
	}

	@Test
	void isEnd() {
		// given
		for (int i = 0; i < 10; i++) {
			racingCar.race(new RandomDeciderFactory());
		}

		// when
		boolean bool = racingCar.isEnd();

		// then
		Assertions.assertThat(bool)
				.isTrue();
	}

	@Test
	void getPlayerNames() {
		// when
		List<String> results = racingCar.getPlayerNames();

		// then
		Assertions.assertThat(results)
				.containsExactly("a", "b", "c", "d");
	}

	@Test
	void getPlayerPositions() {
		// given
		racingCar.race(new TestDeciderFactory());
		racingCar.race(new TestDeciderFactory());

		// when
		List<Integer> results = racingCar.getPlayerPositions();

		// then
		Assertions.assertThat(results)
				.containsExactly(2,2,2,2);
	}
}