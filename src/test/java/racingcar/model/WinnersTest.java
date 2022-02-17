package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

	int expectMaxPosition = 4;
	private final Winners winners=new Winners();

	@DisplayName("우승자가 한명인 경우")
	@Test
	public void testFindWinner() {
		//given
		List<RacingCar> cars;
		//when
		cars = Arrays.asList(
			new RacingCar("juri", 2),
			new RacingCar("hunch", 1),
			new RacingCar("pobi", expectMaxPosition));
		//then
		assertThat(winners.findWinner(cars)).isEqualTo(Collections.singletonList(new Name("pobi")));
	}

	@DisplayName("우승자가 여러명인 경우")
	@Test
	public void testFindWinners() {
		//given
		List<RacingCar> cars;
		//when
		cars = Arrays.asList(
			new RacingCar("juri", expectMaxPosition),
			new RacingCar("hunch", 1),
			new RacingCar("pobi", expectMaxPosition));
		//then
		assertThat(winners.findWinner(cars)).isEqualTo(List.of(new Name("juri"), new Name("pobi")));
	}
}