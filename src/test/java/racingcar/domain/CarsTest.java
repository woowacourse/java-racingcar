package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
	private Cars cars;

	@BeforeEach
	void setUp() {
		Car car1 = new Car("a");
		Car car2 = new Car("b");
		Car car3 = new Car("c");
		for (int i = 0; i < 3; i++) {
			car1.move(4);
		}
		for (int i = 0; i < 5; i++) {
			car2.move(4);
		}
		for (int i = 0; i < 5; i++) {
			car3.move(4);
		}
		cars = new Cars(Arrays.asList(car1, car2, car3));
	}

	@Test
	void 우승자_2명() {
		assertThat(cars.getWinners().size()).isEqualTo(2);
	}

	@Test
	void 우승자_이름() {
		assertThat(cars.getWinners().get(0).getName()).isEqualTo("b");
		assertThat(cars.getWinners().get(1).getName()).isEqualTo("c");
	}

	@Test
	void 우승자_포지션() {
		assertThat(cars.getWinners().get(0).getPosition()).isEqualTo(5);
	}
}
