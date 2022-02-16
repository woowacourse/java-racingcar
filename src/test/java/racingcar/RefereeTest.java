package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
	@Test
	public void 랜덤값이_3일때_차_전진_판단() {
		Car car = new Car("kun");
		assertThat(Referee.canCarMove(3)).isFalse();
	}

	@Test
	public void 랜덤값이_4일때_차_전진_판단() {
		Car car = new Car("kun");
		assertThat(Referee.canCarMove(4)).isTrue();
	}
	@Test
	public void 랜덤값이_5일때_차_전진_판단() {
		Car car = new Car("kun");
		assertThat(Referee.canCarMove(5)).isTrue();
	}

	@Test
	public void 우승자_판정() {
		List<Car> carList = new ArrayList<>();
		Car car1 = new Car("forky");
		Car car2 = new Car("kun");
		carList.add(car1);
		carList.add(car2);
		Cars cars = new Cars(carList);

		car1.move(true);

		assertThat(Referee.judgeWinner(cars, 1)).containsExactly(car1);
	}

	@Test
	public void 우승자_여러명() {
		Cars cars = new Cars(CarFactory.of("forky,kun"));
		assertThat(Referee.judgeWinner(cars, 0).size()).isEqualTo(2);
	}
}
