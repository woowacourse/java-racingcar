package racingCar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingCar.model.Car;
import racingCar.model.RacingCars;

class RacingCarsServiceTest {

	@Test
	public void 우승자_찾기_테스트() throws Exception {
		int expectMaxPosition = 4;
		Car car1 = new Car("juri");
		Car car2 = new Car("juri2");
		Car car3 = new Car("juri3");
		for (int i = 0; i < 2; i++) {
			car1.move();
		}
		for (int i = 0; i < 1; i++) {
			car2.move();
		}
		for (int i = 0; i < expectMaxPosition; i++) {
			car3.move();
		}

		RacingCars cars = new RacingCars(new ArrayList<>(Arrays.asList("a", "b", "c")));
		cars.addCar(car1);
		cars.addCar(car2);
		cars.addCar(car3);
		ArrayList<String> result = new ArrayList<>(List.of("juri3"));
		assertThat(result).isEqualTo(cars.getWinners(expectMaxPosition));
	}
}