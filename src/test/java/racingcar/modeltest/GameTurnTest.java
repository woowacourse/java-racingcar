package racingcar.modeltest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.model.GameTurn;

public class GameTurnTest {
	@Test
	public void 남은_턴_확인() {
		GameTurn gameTurn = new GameTurn(0);
		boolean result = gameTurn.isPositive();
		assertThat(result).isEqualTo(false);
	}
}
