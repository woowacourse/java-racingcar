package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;

public class RacingGameTest {

	@Test
	@DisplayName("레이싱게임 종료조건 미충족 체크 잘 하는지 테스트")
	public void isEndTest_종료조건_미충족() {
		RacingGame racingGame = new RacingGame("pobi,josh", 1);
		assertThat(racingGame.isEnd()).isEqualTo(false);
	}

	@Test
	@DisplayName("레이싱게임 종료조건 충족 체크 잘 하는지 테스트")
	public void isEndTest_종료조건_충족() {
		RacingGame racingGame = new RacingGame("pobi,josh", 1);
		racingGame.doOneTrial();
		assertThat(racingGame.isEnd()).isEqualTo(true);
	}
}
