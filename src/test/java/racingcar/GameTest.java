package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTest {
	@Test
	public void 랜덤값_부여_테스트() {
		Game game = new Game();
		assertThat(game.makeRandomValue(2) < 2).isTrue();
	}
}
