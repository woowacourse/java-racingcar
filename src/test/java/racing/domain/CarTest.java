package racing.domain;

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
		CarGenerator carGenerator = new CarGenerator();
		List<Car> car = carGenerator.carGenerate(input);
		Cars cars = new Cars(car);

		assertThat(cars.getSize()).isEqualTo(input.size());
		assertThat(cars.getAllNames()).isEqualTo(input);
	}

	@Test
	public void goForwardTest() {
		int number = 5;
		Car car = new Car("자동차1");

		car.goForward(number);
		assertThat(car.getPosition()).isEqualTo(1);

		number = 2;

		car.goForward(number);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
