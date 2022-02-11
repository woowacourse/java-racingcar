package racingCar.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import racingCar.model.Car;

class RacingCarsServiceTest {

	RacingCarsService racingCarsService = new RacingCarsService();

	@Test
	public void 최대값_찾기_테스트() throws Exception {
		int expectMaxPosition = 4;
		Car car1 = new Car("juri");
		Car car2 = new Car("hunch");
		Car car3 = new Car("pobi");
		for (int i = 0; i < 2; i++) {
			car1.move();
		}
		for (int i = 0; i < 1; i++) {
			car2.move();
		}
		for (int i = 0; i < expectMaxPosition; i++) {
			car3.move();
		}
		racingCarsService.cars = new ArrayList<>(Arrays.asList(new Car[] {car1, car2, car3}));
		assertThat(racingCarsService.findMaxPosition()).isEqualTo(expectMaxPosition);
	}

	@Test
	public void 우승자_찾기_테스트() throws Exception {
		int expectMaxPosition = 4;
		Car car1 = new Car("juri");
		Car car2 = new Car("hunch");
		Car car3 = new Car("pobi");
		for (int i = 0; i < 2; i++) {
			car1.move();
		}
		for (int i = 0; i < 1; i++) {
			car2.move();
		}
		for (int i = 0; i < expectMaxPosition; i++) {
			car3.move();
		}
		racingCarsService.cars = new ArrayList<>(Arrays.asList(new Car[] {car1, car2, car3}));
		ArrayList<String> result = new ArrayList<>(Arrays.asList(new String[] {"pobi"}));
		assertThat(racingCarsService.findWinner()).isEqualTo(result);
	}
}