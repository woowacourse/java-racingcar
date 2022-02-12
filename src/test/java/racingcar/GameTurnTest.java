package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.model.GameTurn;

public class GameTurnTest {

	@Test
	public void 횟수_숫자_확인() {
		assertThatThrownBy(() -> new GameTurn("a"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_양수_확인() {
		assertThatThrownBy(() -> new GameTurn("-1"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 남은_횟수_확인() {
		GameTurn gameTurn = new GameTurn("1");
		boolean result = gameTurn.isPositive();
		assertThat(result).isEqualTo(true);
	}
}
