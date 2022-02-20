package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTurnTest {
	@Test
	public void 남은_턴_확인() {
		GameTurn gameTurn = new GameTurn("1");
		gameTurn.play();
		boolean result = gameTurn.checkRemain();
		assertThat(result).isEqualTo(false);
	}
}
