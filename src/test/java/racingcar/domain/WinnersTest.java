package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

	@Test
	@DisplayName("단독 우승 시 쉼표가 없는 지")
	void onlyOneWinner() {
		Winners winners = new Winners(Collections.singletonList(new Car("pobi")));
		assertThat(winners).hasToString(("pobi"));
	}

	@Test
	@DisplayName("toString()")
	void toStringTest() {
		Winners winners = new Winners(Arrays.asList(new Car("pobi"), new Car("kyle")));
		assertThat(winners).hasToString(("pobi, kyle"));
	}
}
