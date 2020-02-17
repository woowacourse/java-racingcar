package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
