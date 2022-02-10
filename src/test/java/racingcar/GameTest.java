package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTest {
	@Test
	public void 랜덤값_부여_테스트() {
		Game game = new Game();
		for (int i = 0; i < 3; i++) {
			int randomValue = game.makeRandomValue();
			assertThat(randomValue >= 0 && randomValue <= 9).isTrue();
		}
	}
}
