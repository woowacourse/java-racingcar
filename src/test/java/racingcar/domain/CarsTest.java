package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.strategy.FixedMovingStrategy;

@DisplayName("우승자가")
class CarsTest {

	private Car car1;
	private Car car2;
	private Car car3;

	@BeforeEach
	void setUp() {
		// given
		car1 = Car.builder().movingStrategy(new FixedMovingStrategy()).build();
		car2 = Car.builder().movingStrategy(new FixedMovingStrategy()).build();
		car3 = Car.builder().movingStrategy(new FixedMovingStrategy()).build();
	}

	@Test
	@DisplayName("한명일 때")
	public void Only_One_Winner() {
		// when
		car1.move(3);
		car2.move(1);
		car3.move(2);

		Cars cars = new Cars(List.of(car1, car2, car3));
		List<Car> winners = cars.getWinners();

		// then
		assertThat(winners).containsExactly(car1);
	}

	@Test
	@DisplayName("여러명일 때")
	public void Two_Or_More_Winners() {
		// when
		car1.move(3);
		car2.move(1);
		car3.move(3);

		Cars cars = new Cars(List.of(car1, car2, car3));
		List<Car> winners = cars.getWinners();

		// then
		assertThat(winners).containsExactly(car1, car3);
	}
}
