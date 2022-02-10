package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingServiceTest {
	private static final int PROCEED_FlAG_NUMBER = 4;

	@Test
	void 우승자_판단() {
		Car carA = new Car("A");
		Car carB = new Car("B");
		Car carC = new Car("C");
		Car carD = new Car("D");

		carA.proceed(PROCEED_FlAG_NUMBER);

		List<Car> cars = new ArrayList<Car>();
		cars.add(carA);
		cars.add(carB);
		cars.add(carC);
		cars.add(carD);

		RacingService racingService = new RacingService(cars);
		assertThat(racingService.findWinners()).contains(carA);
	}

	@Test
	void 중복_우승자_판단() {
		Car carA = new Car("A");
		Car carB = new Car("B");
		Car carC = new Car("C");
		Car carD = new Car("D");

		carA.proceed(PROCEED_FlAG_NUMBER);
		carB.proceed(PROCEED_FlAG_NUMBER);

		List<Car> cars = new ArrayList<Car>();
		cars.add(carA);
		cars.add(carB);
		cars.add(carC);
		cars.add(carD);

		RacingService racingService = new RacingService(cars);
		assertThat(racingService.findWinners()).contains(carA, carB);
	}
}
