package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;

class RacingCarServiceTest {

	private RacingCarService racingCarService;
	private final int expectMaxPosition = 4;

	public void customRacingCars() {
		Car car1 = new Car("juri", 2);
		Car car2 = new Car("hunch", 1);
		Car car3 = new Car("pobi", expectMaxPosition);
		racingCarService = new RacingCarService(new ArrayList<>(Arrays.asList(car1, car2, car3)));
	}

	@Test
	public void 최대값_찾기_테스트() {
		customRacingCars();
		assertThat(racingCarService.findMaxPosition()).isEqualTo(expectMaxPosition);
	}

	@Test
	public void 우승자_찾기_테스트() {
		customRacingCars();
		ArrayList<String> result = new ArrayList<>(Collections.singletonList("pobi"));
		assertThat(racingCarService.findWinner()).isEqualTo(result);
	}
}