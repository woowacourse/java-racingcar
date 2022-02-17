package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

	@Test
	public void 우승자_판정() {
		List<Car> carList = new ArrayList<>();
		Car car1 = new Car("forky");
		Car car2 = new Car("kun");
		carList.add(car1);
		carList.add(car2);
		Cars cars = new Cars(carList);
		NumberGenerator numberGenerator = new MovableNumberGenerator();

		car1.move(numberGenerator);

		assertThat(Referee.judgeWinner(cars, 1)).containsExactly(car1);
	}

	@Test
	public void 우승자_여러명() {
		Cars cars = new Cars(CarFactory.of("forky,kun"));
		assertThat(Referee.judgeWinner(cars, 0).size()).isEqualTo(2);
	}
}
