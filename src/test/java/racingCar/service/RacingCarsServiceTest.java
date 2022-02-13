package racingCar.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingCar.model.Car;
import racingCar.model.RacingCars;

class RacingCarsServiceTest {
	@Test
	public void 게임_작동_테스트() {
		//given
		RacingCarsService.initiateCars("juri,hunch");
		RacingCarsService.initiateCount(5);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		//when
		RacingCarsService.runGame();
		String result = out.toString();

		//then
		assertThat(result)
			.contains("","실행 결과","juri : -","hunch : -");
	}

	@Test
	public void 우승자_찾기_테스트() {
		//given
		int expectMaxPosition = 4;
		RacingCars cars = new RacingCars(new ArrayList<>(Arrays.asList("juri", "hunch")));
		Car winCar = new Car("pobi");
		cars.addCar(winCar);
		ArrayList<String> result = new ArrayList<>(List.of("pobi"));

		//when
		for (int i = 0; i < expectMaxPosition; i++) {
			winCar.move();
		}

		//then
		assertThat(result)
			.isEqualTo(cars.getSamePositionCars(expectMaxPosition));
	}
}