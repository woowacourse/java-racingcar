package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import racingcar.utils.FiveGenerator;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomGenerator;
import racingcar.utils.ZeroGenerator;

public class RacingGameTest {

	private static RacingGame racingGame;
	private static NumberGenerator zeroGenerator = new ZeroGenerator();
	private static NumberGenerator fiveGenerator = new FiveGenerator();

	@BeforeAll
	static void beforeAll() {
		racingGame = new RacingGame(
			new Cars("앨런,포비,홍빈"), 5);
	}

	@Test
	void isEnd() {
		racingGame = new RacingGame(
			new Cars("앨런,포비,홍빈"), 5);
		for (int i = 0; i < 5; i++)
			racingGame.race(new RandomGenerator());

		assertThat(racingGame.isEnd()).isTrue();
	}

	@Test
	void race() {
		racingGame.race(fiveGenerator);
		racingGame.race(zeroGenerator);
		racingGame.race(fiveGenerator);

		assertThat(racingGame.getCars()).isEqualTo(
			List.of(
				new Car("앨런", 2),
				new Car("포비", 2),
				new Car("홍빈", 2)
			)
		);
	}

	@Test
	void getCars() {
		assertThat(racingGame.getCars()).isEqualTo(
			List.of(
				new Car("앨런", 0),
				new Car("포비", 0),
				new Car("홍빈", 0)
			)
		);
	}
}
