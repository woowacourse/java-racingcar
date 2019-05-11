package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {

	@Test
	public void 게임결과목록에서_winners_리스트를_잘_가지고오는지_검사() {
		List<RacingGameRound> gameRounds = new ArrayList<>();

		gameRounds.add(new RacingGameRound(Arrays.asList(new Car("red", 1)
				, new Car("blue", 1), new Car("green", 1))));

		gameRounds.add(new RacingGameRound(Arrays.asList(new Car("red", 1)
				, new Car("blue", 2), new Car("green", 2))));

		List<String> expected = Arrays.asList("blue", "green");

		assertThat(new RacingGameResult(gameRounds).getFinalWinners()).isEqualTo(expected);
	}
}