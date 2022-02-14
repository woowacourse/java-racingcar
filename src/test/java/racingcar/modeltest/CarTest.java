package racingcar.modeltest;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.controller.RacingCarGame;
import racingcar.model.Car;

public class CarTest {
	RacingCarGame racingCarGame = new RacingCarGame();

	@Test
	public void 자동차_이름_구분() {
		List<String> result = racingCarGame.splitCarNames("배카라,아스피");
		assertThat(result).isEqualTo(Arrays.asList("배카라", "아스피"));
	}

	@Test
	public void 전진_조건() {
		Car car = new Car("아스피");
		boolean result = car.checkMovingCondition(4);
		assertThat(result).isEqualTo(true);
	}
}
