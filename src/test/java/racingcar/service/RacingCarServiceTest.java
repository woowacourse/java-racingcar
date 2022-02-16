package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

class RacingCarServiceTest {

	private RacingCarService racingCarService;
	private final int EXPECT_MAXIMUM_POSITION = 4;

	@BeforeEach
	public void customRacingCars() {
		racingCarService = new RacingCarService(Arrays.asList(
			new Car("juri", 2),
			new Car("hunch", 1),
			new Car("pobi", EXPECT_MAXIMUM_POSITION)));
	}

	@Test
	public void 우승자_찾기_테스트() {
		assertThat(racingCarService.findWinner()).isEqualTo(Collections.singletonList("pobi"));
	}
}