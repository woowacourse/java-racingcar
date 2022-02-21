package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTurnTest {
	@ParameterizedTest
	@ValueSource(strings = {"1", "100", "25"})
	public void 남은_턴이_있는지_확인(String turn) {
		GameTurn gameTurn = new GameTurn(turn);
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
