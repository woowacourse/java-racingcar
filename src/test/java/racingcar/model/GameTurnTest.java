package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTurnTest {
	@Test
	public void 남은_턴이_있는지_확인() {
		GameTurn gameTurn = new GameTurn("1");
		boolean result = gameTurn.checkRemain();
		assertThat(result).isEqualTo(true);
	}

	@Test
	public void 턴이_차감되는지_테스트() {
		GameTurn gameTurn = new GameTurn("1");
		gameTurn.play();
		assertThat(gameTurn.getGameTurn()).isEqualTo(0);
	}
}
