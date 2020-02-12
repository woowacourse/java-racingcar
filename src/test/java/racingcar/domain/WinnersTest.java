package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class WinnersTest {
	@Test
	void constructor() {
		Winners winners = new Winners(Arrays.asList(new String[] {"pobi", null, null}));
		assertThat(winners.contains("pobi")).isTrue();
		assertThat(winners.contains(null)).isFalse();
		assertThat(winners.contains("kyle")).isFalse();
	}

	@Test
	void toStringTest() {
		Winners winners = new Winners(Arrays.asList(new String[] {"pobi", "kyle", null}));
		assertThat(winners).hasToString(("pobi, kyle"));
	}

	@Test
	void onlyOneWinner() {
		Winners winners = new Winners(Arrays.asList(new String[] {"pobi"}));
		assertThat(winners).hasToString(("pobi"));
	}
}
