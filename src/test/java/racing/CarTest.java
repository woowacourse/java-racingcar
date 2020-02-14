package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racing.controller.CarGenerator;
import racing.domain.Car;
import racing.domain.RacingGame;

public class CarTest {
	@Test
	public void carInitTest() {
		List<String> input = Arrays.asList("A", "B", "C");
		CarGenerator carGenerator = new CarGenerator();
		RacingGame racingGame = new RacingGame(carGenerator.generateCars(input));

		assertThat(racingGame.carSize()).isEqualTo(input.size());
		assertThat(racingGame.getAllNames()).isEqualTo(input);
	}

	@ParameterizedTest
	@MethodSource("generateCar")
	public void goForwardTest(Car car, int forwardNumber, int expectedPosition) {
		car.goForward(forwardNumber);
		assertThat(car.getPosition()).isEqualTo(expectedPosition);
	}

	static Stream<Arguments> generateCar() {
		return Stream.of(
			Arguments.of(new Car("자동차1"), 0, 0),
			Arguments.of(new Car("자동차2"), 3, 0),
			Arguments.of(new Car("자동차3"), 4, 1),
			Arguments.of(new Car("자동차4"), 9, 1)
		);
	}

	@DisplayName("'자동차 이름 : 자동차 위치' 출력 테스트")
	@Test
	public void toStringTest() {
		String expected = "자동차1 : -";
		Car car = new Car("자동차1");
		car.goForward(5);

		assertThat(car.toString()).isEqualTo(expected);
	}
}
