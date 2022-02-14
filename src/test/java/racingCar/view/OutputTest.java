package racingCar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.model.RacingCars;

class OutputTest {

	@DisplayName("차_상태확인_잘되는지_검사")
	@Test
	void test1() {
		//given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		RacingCars cars = new RacingCars(Arrays.asList("jiwoo","juri"));
		cars.get().get(0).move();
		cars.get().get(0).move();

		//when
		Output.printRoundResult(cars);

		//then
		assertThat(out.toString())
			.contains("jiwoo : --\n")
			.contains("juri : \n");
	}
}