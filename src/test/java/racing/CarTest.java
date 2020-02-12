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

import racing.domain.Car;
import racing.domain.Cars;

public class CarTest {
	@Test
	public void carInitTest() {
		List<String> input = Arrays.asList("A", "B", "C");
		Cars cars = new Cars(input);
		assertThat(cars.size()).isEqualTo(input.size());
		assertThat(cars.getAllNames()).isEqualTo(input);
	}

	@ParameterizedTest
	@MethodSource("generateInput")
	public void randomGenerateTest(Car car) {
		assertThat(car.randomGenerate()).isBetween(0, 9);
	}

	static Stream<Arguments> generateInput() {
		return Stream.of(
			Arguments.of(new Car("자동차1")),
			Arguments.of(new Car("자동차2")),
			Arguments.of(new Car("자동차3")),
			Arguments.of(new Car("자동차4")),
			Arguments.of(new Car("자동차5"))
		);
	}

	@Test
	public void goForwardTest() {
		int number = 5;
		Car car = new Car("자동차1");

		car.goForward(number);
		assertThat(car.getPosition()).isEqualTo(1);
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
