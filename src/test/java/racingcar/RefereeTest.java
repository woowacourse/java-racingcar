package racingcar;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
		Set<Car> cars = new HashSet<>();
		Car car1 = new Car("forky");
		Car car2 = new Car("kun");
		car1.move(true);
		cars.add(car1);
		cars.add(car2);
		assertThat(Referee.judgeWinner(cars, 1)).containsExactly(car1);
	}

	@Test
	public void 우승자_여러명() {
		Cars cars = new Cars(CarFactory.of("forky,kun"));
		assertThat(Referee.judgeWinner(cars.getCars(), 0).size()).isEqualTo(2);
	}
}
