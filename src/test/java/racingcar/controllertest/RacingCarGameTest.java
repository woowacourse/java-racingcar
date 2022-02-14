package racingcar.controllertest;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.controller.RacingCarGame;
import racingcar.model.Car;

public class RacingCarGameTest {
	RacingCarGame racingCarGame = new RacingCarGame();

	@Test
	public void 횟수_숫자_확인() {
		assertThatThrownBy(() -> racingCarGame.checkGameTurnNumber("two"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_양수_확인() {
		assertThatThrownBy(() -> racingCarGame.checkGameTurnNumber("-2"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_객체_생성() {
		List<Car> result = racingCarGame.toCar(Arrays.asList("배카라", "아스피"));
		assertThat(result).isEqualTo(Arrays.asList(new Car("배카라"), new Car("아스피")));
	}
}
