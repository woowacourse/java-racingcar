package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.controller.RacingCarGame;

public class RacingCarTest {
	@Test
	public void 자동차_이름_공백() throws Exception {
		RacingCarGame racingCarGame = new RacingCarGame();
		assertThatThrownBy(() -> racingCarGame.checkCarNames(""))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> racingCarGame.checkCarNames(null))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
