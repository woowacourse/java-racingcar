package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

@SuppressWarnings("NonAsciiCharacters")
public class RacingServiceTest {
	private List<Car> cars;
	private Car carA;
	private Car carB;
	private Car carC;
	private Car carD;
	private RacingService racingService;

	@BeforeEach
	void beforeEach(){
		carA = new Car("A");
		carB = new Car("B");
		carC = new Car("C");
		carD = new Car("D");

		cars = new ArrayList<>();
		cars.add(carA);
		cars.add(carB);
		cars.add(carC);
		cars.add(carD);

		racingService = new RacingService(cars);
	}

	@Test
	void 우승자_판단() {
		carA.proceed();
		assertThat(racingService.findWinners()).contains(carA);
	}

	@Test
	void 중복_우승자_판단() {
		carA.proceed();
		carB.proceed();
		assertThat(racingService.findWinners()).contains(carA, carB);
	}
}
